DELIMITER $$

CREATE TRIGGER PhoneNumber 
BEFORE INSERT ON emergency_contacts 
FOR EACH ROW 
BEGIN
  IF NEW.Phone_Number NOT LIKE '+961--------' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid phone number format';
  END IF;
END;
$$

CREATE TRIGGER PatientSSNOnInsurancePlan
BEFORE INSERT ON insurance_plan
FOR EACH ROW
BEGIN
  IF NEW.Patient_SSN NOT IN (SELECT Patient_SSN FROM patients) THEN
    DELETE FROM insurance_plan WHERE Patient_SSN = new.Patient_SSN;
  END IF;
END;
$$

CREATE TRIGGER PatientSSNOnMedicalFile
BEFORE INSERT ON medical_file
FOR EACH ROW
BEGIN
  IF NEW.Patient_SSN NOT IN (SELECT Patient_SSN FROM patients) THEN
    DELETE FROM medical_file WHERE Patient_SSN = new.Patient_SSN;
  END IF;
END;
$$

CREATE TRIGGER DoctorIDOnMedicalFile
BEFORE INSERT ON medical_file
FOR EACH ROW
BEGIN
  IF NEW.Doctor_ID NOT IN (SELECT Doctor_ID FROM doctor) THEN
    UPDATE new SET Doctor_ID = NULL;
  END IF;
END;
$$

CREATE TRIGGER NoSameName
BEFORE INSERT ON DOCTOR
FOR EACH ROW
BEGIN
  DECLARE count_names INT;
  SELECT COUNT(*) INTO count_names
  FROM DOCTOR
  WHERE First_Name = NEW.First_Name AND Last_Name = NEW.Last_Name;
  IF count_names > 0 THEN
    SET NEW.First_Name = CONCAT(NEW.First_Name, '2.0');
    SET NEW.Last_Name = CONCAT(NEW.Last_Name, '2.0');
  END IF;
END;
$$

CREATE TRIGGER NoSameEmail
BEFORE INSERT ON DOCTOR
FOR EACH ROW
BEGIN
  DECLARE count_emails INT;
  SELECT COUNT(*) INTO count_emails
  FROM DOCTOR
  WHERE email = NEW.email;
  IF count_emails > 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Email already exists';
  END IF;
END;
$$

CREATE TRIGGER check_Starting_Year_before_insert
BEFORE INSERT ON doctor
FOR EACH ROW
BEGIN
    IF NEW.Starting_Year < '1955-01-01' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Doctor cannot be born before 1935';
    END IF;
END;
$$

CREATE TRIGGER check_Starting_Year_before_update
BEFORE UPDATE ON doctor
FOR EACH ROW
BEGIN
    IF NEW.Starting_Year < '1955-01-01' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'We are sorry';
    END IF;
END;
$$

CREATE TRIGGER NoSameNamePatients
BEFORE INSERT ON PATIENTS
FOR EACH ROW
BEGIN
  DECLARE count_names INT;
  SELECT COUNT(*) INTO count_names
  FROM PATIENTS
  WHERE First_Name = NEW.First_Name AND Last_Name = NEW.Last_Name;
  IF count_names > 0 THEN
    SET NEW.First_Name = CONCAT(NEW.First_Name, '2.0');
    SET NEW.Last_Name = CONCAT(NEW.Last_Name, '2.0');
  END IF;
END;
$$


DELIMITER $$