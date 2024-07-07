CREATE TABLE MEDICAL_FACILTIY(
    Medical_Facility_ID INTEGER,
    Facility_Name VARCHAR (30),
    Facility_Location VARCHAR(70),
    ContactInformation VARCHAR(100),
    PRIMARY KEY (Medical_Facility_ID)
    );

CREATE TABLE DOCTOR(
    Doctor_ID INTEGER,
    First_Name VARCHAR(30) NOT NULL,
    Last_Name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
	Phone_Number VARCHAR(8) NOT NULL UNIQUE CHECK (Phone_Number LIKE '+961%'),
    Title VARCHAR(10),
    Specialty VARCHAR(50),
    Starting_Year INTEGER,
    Office_Number INTEGER,
    Medical_Facility_ID INTEGER,
    PRIMARY KEY (Doctor_ID),
    CONSTRAINT FID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID)    
);

CREATE TABLE PATIENTS(
    Patient_SSN INTEGER,
    Patient_ID INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    Date_Of_Birth DATE NOT NULL,
    First_Name VARCHAR(30) NOT NULL,
    Last_Name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
	Phone_Number VARCHAR(8) NOT NULL UNIQUE CHECK (Phone_Number LIKE '+961%'),
    Address VARCHAR(80),
    Gender CHAR(1) NOT NULL,
	Medical_History VARCHAR (50000),
    PRIMARY KEY (Patient_SSN)
);

CREATE TABLE INSURANCE_PLAN(
    Insurance_Plan_ID INTEGER AUTO_INCREMENT,
    Company_Provider VARCHAR(30) NOT NULL,
    Class VARCHAR(3) NOT NULL,
    ISSUING_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    Patient_SSN INTEGER NOT NULL UNIQUE,
    PRIMARY KEY (Insurance_Plan_ID),
    CONSTRAINT PID FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
);

CREATE TABLE EMERGENCY_CONTACTS(
    Phone_Number VARCHAR (8),
    Name VARCHAR(30),
    Relationship VARCHAR(12),
    PRIMARY KEY (Phone_Number)
);

CREATE TABLE MEDICAL_FILE(
    Medical_File_ID INTEGER,
    Date_Of_Creation DATE,
    Patient_SSN INTEGER UNIQUE,
    Doctor_ID INTEGER,
    Prescription VARCHAR(500),
    Description VARCHAR(500),
    Date DATE,
    PRIMARY KEY (Medical_File_ID, Patient_SSN),
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN),
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID)
);


CREATE TABLE LAB_TEST(
    Test_ID INTEGER,
    Test_Name VARCHAR(30),
    Date DATE,
    Report VARCHAR(1000),
    Reason VARCHAR(500),
    Medical_File_ID INTEGER,
    PRIMARY KEY (Test_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
);

CREATE TABLE RADIOLOGY(
    Radiology_ID INTEGER,
    Radiology_Name VARCHAR(30),
    Date DATE,
    Report VARCHAR(1000),
    Reason VARCHAR(500),
    Images VARBINARY(1000),
    Medical_File_ID INTEGER,
    PRIMARY KEY (Radiology_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
);

CREATE TABLE SURGERY(
    Surgery_ID INTEGER,
    Surgery_Name VARCHAR(30),
    Date DATE,
    Aim VARCHAR(100),
    PRIMARY KEY (Surgery_ID)
);

CREATE TABLE TREATMENT(
    Treatment_ID INTEGER,
    Treatment_Name VARCHAR(30),
    Reason VARCHAR(100),
    Start_Date DATE,
    END_DATE DATE,
    Medical_File_ID INTEGER,
    PRIMARY KEY (Treatment_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_File_ID) REFERENCES MEDICAL_FILE(Medical_File_ID)
);

CREATE TABLE APPOINTMENT(
    Appointment_ID INTEGER,
    Day VARCHAR(10),
    Start_Time TIME,
    End_Time TIME,
    Patient_SSN INTEGER,
    Reason VARCHAR(100),
    Status_Of_Appointment VARCHAR(10),
    PRIMARY KEY (Appointment_ID),
    CONSTRAINT PSSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN)
);

CREATE TABLE PERFORM_SURGERY(
    Doctor_ID INTEGER,
    Medical_Facility_ID INTEGER,
    Patient_SSN INTEGER,
    Surgery_ID INTEGER,
    Price DECIMAL(10,2),
    Successful BOOLEAN,
    Date DATE,
    PRIMARY KEY (Doctor_ID, Medical_Facility_ID, Patient_SSN, Surgery_ID),
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID),
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN),
    CONSTRAINT SID FOREIGN KEY (Surgery_ID) REFERENCES SURGERY(Surgery_ID)
);

CREATE TABLE IS_AVAILABLE(
    Doctor_ID INTEGER,
    Appointment_ID INTEGER,
    PRIMARY KEY (Doctor_ID, Appointment_ID),
    CONSTRAINT DID FOREIGN KEY (Doctor_ID) REFERENCES DOCTOR(Doctor_ID),
    CONSTRAINT AID FOREIGN KEY (Appointment_ID) REFERENCES APPOINTMENT(Appointment_ID)
);

CREATE TABLE COVERS_SURGERY(
    Insurance_Plan_ID INTEGER,
    Surgery_ID INTEGER,
    Percentages DECIMAL(3,2), 
    PRIMARY KEY (Insurance_Plan_ID, Surgery_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID),
    CONSTRAINT SID FOREIGN KEY (Surgery_ID) REFERENCES SURGERY(Surgery_ID)
);

CREATE  TABLE COVERS_TREATMENT(
    Insurance_Plan_ID INTEGER,
    Treatment_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Treatment_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID),
    CONSTRAINT TID FOREIGN KEY (Treatment_ID) REFERENCES TREATMENT(Treatment_ID)
);

CREATE TABLE COVERS_RADIO(
    Insurance_Plan_ID INTEGER,
    Radiology_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Radiology_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID),
    CONSTRAINT RID FOREIGN KEY (Radiology_ID) REFERENCES RADIOLOGY(Radiology_ID)
);

CREATE TABLE COVERS_TEST(
    Insurance_Plan_ID INTEGER,
    Test_ID INTEGER,
    Percentages DECIMAL(3,2),
    PRIMARY KEY (Insurance_Plan_ID, Test_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID),
    CONSTRAINT TID FOREIGN KEY (Test_ID) REFERENCES LAB_TEST(Test_ID)
);

CREATE TABLE HAS_EMERGENCY_CONTACTS(
    Patient_SSN INTEGER,
    Phone_Number VARCHAR(8),
    PRIMARY KEY (Patient_SSN, Phone_Number),
    CONSTRAINT SSN FOREIGN KEY (Patient_SSN) REFERENCES PATIENTS(Patient_SSN),
    CONSTRAINT PN FOREIGN KEY (Phone_Number) REFERENCES EMERGENCY_CONTACTS(Phone_Number)
);

CREATE TABLE ADMITS(
    Insurance_Plan_ID INTEGER,
    Medical_Facility_ID INTEGER,
    PRIMARY KEY (Insurance_Plan_ID, Medical_Facility_ID),
    CONSTRAINT IPID FOREIGN KEY (Insurance_Plan_ID) REFERENCES INSURANCE_PLAN(Insurance_Plan_ID),
    CONSTRAINT MFID FOREIGN KEY (Medical_Facility_ID) REFERENCES MEDICAL_FACILTIY(Medical_Facility_ID)
);