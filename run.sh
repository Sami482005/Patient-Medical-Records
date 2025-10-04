#!/usr/bin/env bash
# Cross-platform launcher for Patient Medical Records
BASEDIR="$(cd "$(dirname "$0")" && pwd)"
LIB="$BASEDIR/lib/mysql-connector-j-9.0.0.jar"
JAVA_EXEC="${JAVA_HOME:-java}"

# Ensure JDBC driver exists
if [ ! -f "$LIB" ]; then
  echo "Missing JDBC driver at $LIB"
  exit 1
fi

# Build the runnable JAR automatically if missing or if BUILD=1
if [ "${BUILD:-0}" = "1" ] || [ ! -f "$BASEDIR/dist/app.jar" ]; then
  echo "Building runnable JAR (dist/app.jar) ..."
  cd "$BASEDIR" || exit 1
  mkdir -p out dist
  # Compile Java sources
  if ! javac -cp "$LIB" -d out $(find src -name "*.java"); then
    echo "Compilation failed. Fix Java errors before packaging." >&2
    exit 1
  fi

  # Copy non-java resources (images, .form files, etc.) into out/
  find src -type f ! -name '*.java' -print0 | while IFS= read -r -d '' file; do
    target="out/${file#src/}"
    mkdir -p "$(dirname "$target")"
    cp "$file" "$target"
  done

  # Create jar
  if ! jar --create --file dist/app.jar -C out .; then
    echo "Failed to create dist/app.jar" >&2
    exit 1
  fi
  echo "Built dist/app.jar"
fi

# Optional: create the database and import schema before launching the app
# Set SKIP_DB_SETUP=1 to skip this step. Configure DB connection via environment variables:
# DB_HOST, DB_PORT, DB_USER, DB_PASS, DB_NAME, MYSQL_CMD
if [ "${SKIP_DB_SETUP:-0}" != "1" ]; then
  MYSQL_CMD="${MYSQL_CMD:-mysql}"
  DB_HOST="${DB_HOST:-localhost}"
  DB_PORT="${DB_PORT:-3306}"
  DB_USER="${DB_USER:-root}"
  DB_PASS="${DB_PASS:-}"
  DB_NAME="${DB_NAME:-patient_medical_records}"
  SQL_DIR="$BASEDIR/Schema"
  SQL1="$SQL_DIR/SQL_Queries.sql"
  SQL2="$SQL_DIR/Triggers.sql"

  if [ -f "$SQL1" ] && [ -f "$SQL2" ]; then
    if ! command -v "$MYSQL_CMD" >/dev/null 2>&1; then
      echo "mysql client not found in PATH (tried '$MYSQL_CMD'). Skipping DB setup."
      echo "To run DB setup later, install mysql client or set SKIP_DB_SETUP=1 to skip."
    else
      echo "Setting up database '$DB_NAME' (host=$DB_HOST port=$DB_PORT user=$DB_USER)"
      # Build auth args: avoid leaving -p without value which prompts for password
      if [ -z "$DB_PASS" ]; then
        AUTH_ARGS=( -h"$DB_HOST" -P"$DB_PORT" -u"$DB_USER" )
      else
        AUTH_ARGS=( -h"$DB_HOST" -P"$DB_PORT" -u"$DB_USER" -p"$DB_PASS" )
      fi

      # Create database if not exists
      if ! "$MYSQL_CMD" "${AUTH_ARGS[@]}" -e "CREATE DATABASE IF NOT EXISTS \`$DB_NAME\` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"; then
        echo "Failed to create database '$DB_NAME' -- please check credentials and MySQL server."
        exit 1
      fi

      # Import schema files
      if ! "$MYSQL_CMD" "${AUTH_ARGS[@]}" "$DB_NAME" < "$SQL1"; then
        echo "Failed to import $SQL1"
        exit 1
      fi
      if ! "$MYSQL_CMD" "${AUTH_ARGS[@]}" "$DB_NAME" < "$SQL2"; then
        echo "Failed to import $SQL2"
        exit 1
      fi
      echo "Database '$DB_NAME' setup complete."
    fi
  else
    echo "Schema files not found at $SQL_DIR (expected $SQL1 and $SQL2). Skipping DB setup."
  fi
fi

# Run the jar with classpath including the lib folder
exec "$JAVA_EXEC" -cp "$BASEDIR/dist/app.jar:$LIB" View.main_page "$@"
