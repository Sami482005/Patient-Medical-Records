CREATE TABLE MEDICAL_FACILITY(
    Medical_Facility_ID INTEGER AUTO_INCREMENT UNIQUE,
    Facility_Name VARCHAR (30),
    Facility_Location VARCHAR(70),
    PRIMARY KEY (Medical_Facility_ID)
    );

CREATE TABLE DOCTOR(
    Doctor_ID INTEGER AUTO_INCREMENT,
    First_Name VARCHAR(30),
    Last_Name VARCHAR(30),
    email VARCHAR(30)  UNIQUE,
	Phone_Number VARCHAR(13) UNIQUE  CHECK (Phone_Number LIKE '+961________'),
    Title VARCHAR(10),
    Specialty VARCHAR(50),
    Starting_Year INTEGER,
    Medical_Facility_ID INTEGER,
    PRIMARY KEY (Doctor_ID),
    CONSTRAINT FID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID)    
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE PATIENTS(
    Patient_SSN INTEGER,
    Patient_ID INTEGER UNIQUE AUTO_INCREMENT,
    Date_Of_Birth DATE,
    First_Name VARCHAR(30),
    Last_Name VARCHAR(30),
    email VARCHAR(30)  UNIQUE,
	Phone_Number VARCHAR(13) UNIQUE CHECK (Phone_Number LIKE '+961________'),
    Address VARCHAR(80),
    Gender CHAR(1),
	Medical_History VARCHAR (50000),
    PRIMARY KEY (Patient_SSN)
);

CREATE TABLE INSURANCE_PLAN(
    Insurance_Plan_ID INTEGER AUTO_INCREMENT,
    Company_Provider VARCHAR(30),
    Class VARCHAR(3),
    Issuing_Date DATE,
    End_Date DATE,
    Patient_SSN INTEGER  UNIQUE,
    PRIMARY KEY (Insurance_Plan_ID),
    CONSTRAINT PID FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
    ON DELETE CASCADE
);

CREATE TABLE EMERGENCY_CONTACTS(
    Phone_Number VARCHAR (13) UNIQUE CHECK (Phone_Number LIKE '+961________'),
    Name VARCHAR(30),
    Relationship VARCHAR(12),
    PRIMARY KEY (Phone_Number)
);

CREATE TABLE MEDICAL_FILE(
    Medical_File_ID INTEGER AUTO_INCREMENT,
    Date_Of_Creation DATE,
    Patient_SSN INTEGER UNIQUE,
    Doctor_ID INTEGER,
    Prescription VARCHAR(500),
    Description VARCHAR(500),
    Update_Date DATE, 
    PRIMARY KEY (Medical_File_ID, Patient_SSN),
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
    ON DELETE SET NULL,
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);


CREATE TABLE LAB_TEST(
    Test_ID INTEGER AUTO_INCREMENT,
    Test_Name VARCHAR(30),
    Date DATE,
    Report VARCHAR(1000),
    Reason VARCHAR(500),
    Medical_File_ID INTEGER,
    PRIMARY KEY (Test_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE RADIOLOGY(
    Radiology_ID INTEGER AUTO_INCREMENT,
    Radiology_Name VARCHAR(30),
    Date DATE,
    Report VARCHAR(1000),
    Reason VARCHAR(500),
    Medical_File_ID INTEGER,
    PRIMARY KEY (Radiology_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE SURGERY(
    Surgery_ID INTEGER AUTO_INCREMENT,
    Surgery_Name VARCHAR(30),
    Aim VARCHAR(100),
    PRIMARY KEY (Surgery_ID)
);

CREATE TABLE PERFORM_SURGERY(
    Doctor_ID INTEGER,
    Medical_Facility_ID INTEGER,
    Patient_SSN INTEGER,
    Surgery_ID INTEGER,
    Successful BOOLEAN,
    Date DATE,
    PRIMARY KEY (Doctor_ID, Medical_Facility_ID, Patient_SSN, Surgery_ID),
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    CONSTRAINT MFID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
    ON DELETE CASCADE,
    CONSTRAINT SID FOREIGN KEY (Surgery_ID) REFERENCES SURGERY(Surgery_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE TREATMENT(
    Treatment_ID INTEGER AUTO_INCREMENT,
    Treatment_Name VARCHAR(30),
    Reason VARCHAR(100),
    Start_Date DATE,
    END_DATE DATE,
    Medical_File_ID INTEGER,
    PRIMARY KEY (Treatment_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE APPOINTMENT(
    Appointment_ID INTEGER AUTO_INCREMENT,
    Day VARCHAR(10),
    Start_Time VARCHAR(5),
    End_Time VARCHAR(5),
    PRIMARY KEY (Appointment_ID)
);

CREATE TABLE BOOK_APPOINTMENT(
    Patient_SSN INTEGER, 
    Appointment_ID INTEGER,
    Reason VARCHAR(100),
    PRIMARY KEY (Patient_SSN, Appointment_ID),
    CONSTRAINT PSSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT AID FOREIGN KEY (Appointment_ID) REFERENCES APPOINTMENT(Appointment_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE 
);

CREATE TABLE IS_AVAILABLE(
    Doctor_ID INTEGER,
    Appointment_ID INTEGER,
    PRIMARY KEY (Doctor_ID, Appointment_ID),
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT AID FOREIGN KEY (Appointment_ID) REFERENCES APPOINTMENT(Appointment_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE COVERS_SURGERY(
    Insurance_Plan_ID INTEGER,
    Surgery_ID INTEGER,
    Percentages DECIMAL(3,2), 
    PRIMARY KEY (Insurance_Plan_ID, Surgery_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID)
    ON DELETE CASCADE,
    CONSTRAINT SID FOREIGN KEY (Surgery_ID) REFERENCES SURGERY(Surgery_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE COVERS_TREATMENT(
    Insurance_Plan_ID INTEGER,
    Treatment_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Treatment_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID)
    ON DELETE CASCADE,
    CONSTRAINT TID FOREIGN KEY (Treatment_ID) REFERENCES TREATMENT(Treatment_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE COVERS_RADIO(
    Insurance_Plan_ID INTEGER,
    Radiology_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Radiology_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID)
    ON DELETE CASCADE,
    CONSTRAINT RID FOREIGN KEY (Radiology_ID) REFERENCES RADIOLOGY(Radiology_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE COVERS_TEST(
    Insurance_Plan_ID INTEGER,
    Test_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Test_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID)
    ON UPDATE CASCADE,
    CONSTRAINT TID FOREIGN KEY (Test_ID) REFERENCES LAB_TEST(Test_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE HAS_EMERGENCY_CONTACTS(
    Patient_SSN INTEGER,
    Phone_Number VARCHAR(13),
    PRIMARY KEY (Patient_SSN, Phone_Number),
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT PN FOREIGN KEY (Phone_Number) REFERENCES EMERGENCY_CONTACTS(Phone_Number)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE ADMITS(
    Insurance_Plan_ID INTEGER,
    Medical_Facility_ID INTEGER,
    PRIMARY KEY (Insurance_Plan_ID, Medical_Facility_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID)
    ON DELETE CASCADE,
    CONSTRAINT MFID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);