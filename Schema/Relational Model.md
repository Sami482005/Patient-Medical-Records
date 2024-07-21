MedicalFacility (F_ID, Fname, location)

Doctor (Doctor-ID, first-name, last-name, email, phone_nb, title, specialty, starting_Year #F_ID)

Patients (P_SSN, P_ID, DOB, first-name, last-name, email, address, gender, email, phone_nb, medical_history)

InsurancePlan (IP_ID, class, company_provider, issuing_date, end_date, #P_SSN)

EmergencyContacts (phone_nb, name, relationship, #Patient_SSN)

Medical_File (MF_ID,#P_SSN, #Doctor-ID, prescription)

LabTest (LT_ID, report, name, date, reason, #MF_ID)

Radiology (R_ID, name, date, report, reason, #MF_ID)

Surgery (S_ID, Surgery_name, aim)

Treatments (T_ID, name, reason, startDate, endDate, #MF_ID)

Appointment (A_ID, day, to, from, #P_SSN, reason)

Perform_Surgery (#Doctor_ID, #P_SSN, #Surgery_ID,successful?, Date)

hasAvailability (#Doctor_ID, #A_ID)
