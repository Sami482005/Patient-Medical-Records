# Introduction
This repository includes all the codes needed to create a patient medical record in a hospital.
This repository was created for the purpose of collecting code from the four contributors to this project completed at Lebanese American University for Database Management Systems (BIF375/CSC375).
# Patient Medical Records (Java / MySQL)

This repository contains a Java desktop application (GUI) for managing patient medical records in a hospital environment. The project was implemented as a Database Management Systems course project and includes the UI (Swing / generated forms), the data model classes, and a database access layer that connects to a MySQL database.

This README explains what the project contains, how to set it up locally, where to change configuration (database connection), and points out important implementation notes and next steps.

## Quick summary
- Language: Java (Swing GUI / NetBeans forms)
- DBMS: MySQL (JDBC)
- Intended features: patient records, appointments & scheduling, doctor availability, insurance plans, medical files (prescriptions, lab tests, radiology, surgeries, treatments), basic CRUD operations.

## What is in this repository

- `src/Model/` - Plain Java model classes that represent domain entities (Patient, Doctor, Appointment, Medical_File, Radiology, Treatment, Surgery, Insurance_Plan, ...).
- `src/Control/` - Application control and database access code. The main database helper is `DBAccess.java` which contains methods used by the UI to query/modify the database.
- `src/View/` - GUI forms and frames (NetBeans generated `.form` + `.java` files). These are the screens patients and doctors use (login, booking, viewing reports, schedules, etc.).
- `Schema/` - Database resources: ER diagram, relational model and SQL scripts (look for `SQL_Queries.sql` and `Triggers.sql`). Use these to create the database schema and populate any seed data.
- `mysql-connector-j-9.0.0.jar` - JDBC driver included (you can also use a different connector version; add it to the project's classpath).
- `bin/` - Compiled distribution (if present).

## Requirements

- Java JDK 8 or later (project was tested with newer JDKs; JDK 11+ recommended). The original project notes indicate JDK 22 was used, but JDK 8+ should work for compilation.
- MySQL server (local or remote) and a MySQL client (Workbench, CLI, or similar).
- An IDE such as NetBeans (recommended, because the GUI forms are NetBeans `.form` files) or IntelliJ/Eclipse (you'll lose the visual form editor if not using NetBeans).
- JDBC driver (the repository already contains `mysql-connector-j-9.0.0.jar`).

## Setup (step-by-step)

1. Install Java and MySQL if not already installed.

2. Create the database and schema
	- The project expects a MySQL database containing the tables described in `Schema/`. Use the SQL scripts in `Schema/SQL_Queries.sql` and `Schema/Triggers.sql` to create tables, relations and triggers. From the MySQL command line or Workbench run:

```bash
# example using mysql CLI (adjust user, password and file paths)
mysql -u root -p < Schema/SQL_Queries.sql
mysql -u root -p < Schema/Triggers.sql
```

	- Note: The original DBAccess connection string targets a database named "patient medical records" (with spaces). It's recommended to use a database name without spaces (for example `patient_medical_records`) when you create the DB and then update the connection string accordingly (see "Connection configuration" below).

3. Add the JDBC driver to the project classpath
	- In NetBeans: Right click the project -> Properties -> Libraries -> Add JAR/Folder -> choose `mysql-connector-j-9.0.0.jar`.

4. Configure the application database connection
	- Open `src/Control/DBAccess.java`. There is a connect() method that currently contains a hard-coded connection string, for example:

```java
con = DriverManager.getConnection("jdbc:mysql://localhost/patient medical records", "root", "");
```

	- Change the URL, user and password to match your environment. Example using a safer database name and port 3306:

```java
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_medical_records?serverTimezone=UTC", "root", "your_password");
```

	- Save and rebuild the project in your IDE.

5. Run the application

There are two simple ways to run the app: from your IDE (NetBeans recommended) or from the command line using the provided `run.sh` launcher. The launcher optionally creates/imports the database schema before starting the GUI.

A. Run from NetBeans (recommended during development)
- Open the project in NetBeans (it understands the `.form` files) and click Run -> Run Project. Make sure the JDBC driver `mysql-connector-j-9.0.0.jar` is added to the project Libraries.

B. Build and run from the command line (cross-platform)

This repository includes a cross-platform script `run.sh` (Linux/macOS). For Windows you can run the equivalent Java command shown below or create `run.bat`.

1) Build a runnable JAR (one-time)

The following commands compile the sources and build `dist/app.jar` (you can skip this if you use an IDE):

```bash
# from the repository root
mkdir -p out dist
javac -cp lib/mysql-connector-j-9.0.0.jar -d out $(find src -name "*.java")
jar --create --file dist/app.jar -C out .
```

Notes:
- The commands assume you have a POSIX shell and `javac`/`jar` on PATH. On Windows you can run similar commands in Git Bash or adapt them to PowerShell/cmd.
- The JAR produced above contains your compiled classes. The JDBC driver is left in `lib/mysql-connector-j-9.0.0.jar` and is added to the runtime classpath by `run.sh`.

2) Run with the supplied launcher (Linux / macOS)

`run.sh` will:
- verify the JDBC driver exists at `lib/mysql-connector-j-9.0.0.jar`;
- optionally create the database and import `Schema/SQL_Queries.sql` and `Schema/Triggers.sql` using the `mysql` CLI (if present and not skipped);
- launch the GUI by running the `View.main_page` class.

Basic usage:

```bash
# Simple run, attempt DB setup using defaults (host=localhost user=root, DB_NAME=patient_medical_records)
./run.sh

# Skip DB setup (useful if you already have the DB created or prefer to run SQL manually)
SKIP_DB_SETUP=1 ./run.sh

# Provide DB credentials or a different DB name
DB_USER=root DB_PASS=secret DB_NAME=my_database ./run.sh
```

If you prefer to create the database manually (for example when you have no `mysql` client on PATH), run the SQL files yourself:

```bash
# Example: import schema with the mysql CLI
mysql -h localhost -u root -p < Schema/SQL_Queries.sql
mysql -h localhost -u root -p < Schema/Triggers.sql
```

3) Run on Windows (cmd / PowerShell)

You can run the compiled classes directly with:

```
rem on Windows (cmd)
java -cp "dist/app.jar;lib\mysql-connector-j-9.0.0.jar" View.main_page

:: or in PowerShell
java -cp "dist/app.jar;lib\mysql-connector-j-9.0.0.jar" View.main_page
```

Or create a `run.bat` that mirrors `run.sh`'s behavior (I can add this if you want).

Important notes about the DB connection
- The `run.sh` script imports the SQL into the database named by the `DB_NAME` environment variable (default `patient_medical_records`). The original code in `src/Control/DBAccess.java` uses a hard-coded connection string that referenced a database name with spaces (`jdbc:mysql://localhost/patient medical records`). You must ensure the database name used by `DBAccess.java` and the database created by `run.sh` match.
- Recommended: update the connection string in `DBAccess.java` to use a single-token database name (for example `patient_medical_records`) and include the serverTimezone parameter, e.g.:

```java
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_medical_records?serverTimezone=UTC", "root", "your_password");
```

Troubleshooting
- Missing JDBC driver: If `run.sh` complains about the driver path, make sure `lib/mysql-connector-j-9.0.0.jar` exists. If not, download a compatible MySQL JDBC driver and place it at `lib/`.
- mysql client not found: If `run.sh` cannot find the `mysql` CLI it will skip DB setup; install a client (MySQL client tools / MariaDB client) or import the SQL scripts manually.
- Permissions: Make `run.sh` executable if necessary: `chmod +x run.sh`.
- Headless environments: The app opens a Swing GUI. It will not display in headless servers unless you forward a display (X11) or run in a desktop session.

One-click / cross-platform notes
- On Linux/macOS: make `run.sh` executable and users can double-click/run it from a terminal. To create a true double-clickable app bundle or native installer, consider using `jpackage` (Java 14+) or a packaging tool — I can help add that if you want.
- On Windows: add a small `run.bat` or create an installer; I can add `run.bat` and a minimal installer script on request.

## Default credentials and assumptions

- The code in `DBAccess.java` uses the default MySQL user `root` with an empty password in the repository; if your MySQL server uses a password, update `DBAccess.java` accordingly.
- The code contains SQL statements built by string concatenation (see "Security & code notes" below). Keep this in mind and avoid exposing this app to untrusted inputs in production.

## Main features (high level)

- Patient management: add/update patients, medical history, insurance plan linking.
- Medical files: prescriptions, radiology reports, lab results, surgeries, and treatments are stored and can be retrieved by MRN/SSN.
- Appointment booking & scheduling: patients can view available doctor times and book appointments; doctors can mark availability.
- Doctor workflows: view schedule, add lab/radiology/surgery/treatment records, prescriptions.

## Where to look in the code

- Database access: `src/Control/DBAccess.java` (connection string, SQL queries used by the UI).
- Models: `src/Model/` (entity classes and getters/setters used across the app).
- Views: `src/View/` (NetBeans forms and frame implementations used to interact with the user).
- SQL / schema: `Schema/SQL_Queries.sql`, `Schema/Triggers.sql` (create tables, relations, triggers and seed data if present).

## License & authors

This project was created by the course contributors for Database Management Systems (BIF375/CSC375) at Lebanese American University. See the project files for author attributions.
