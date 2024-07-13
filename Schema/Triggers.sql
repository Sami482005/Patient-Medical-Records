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
  IF NEW.First_Name IN (SELECT First_Name FROM DOCTOR) AND NEW.Last_Name IN (SELECT LAB_TEST FROM DOCTOR) THEN
    UPDATE NEW SET First_Name = NEW.First_Name + "2.0" AND SET Last_Name = NEW.Last_Name + "2.0";
  END IF;
END;
$$

DELIMITER $$