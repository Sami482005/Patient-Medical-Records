MedicalFacility (F_ID, Fname, location)

Doctor (Doctor-ID, first-name, last-name, email, phone_nb, title, specialty, starting_Year #F_ID)

Patients (P_SSN, P_ID, DOB, first-name, last-name, address, gender, email, phone_nb, medical_history)

InsurancePlan (IP_ID, class, company_provider, issuing_date, end_date, #P_SSN)

EmergencyContacts (phone_nb, name, relationship)

Medical_File (MF_ID,#P_SSN, #Doctor-ID, prescription, desc, date)

LabTest (LT_ID, report, type, reason, #MF_ID)

Radiology (R_ID, type, report, reason, #MF_ID)

Surgery (S_ID, Surgery_name, aim)

Treatments (T_ID, name, reason, startDate, endDate, #MF_ID)

Appointment (A_ID, day, to, from,#P_SSN)

Book_Appointment(#Patient_SSN, #Appointment_ID, reasonOfvisit)

Perform_Surgery (#Doctor_ID, #Facility_ID, #P_SSN, #Surgery_ID, price, successful?, Date)

hasAvailability (#Doctor_ID, #Availability_ID)

Has_Emergency_Contacts ( #P_SSN, #EC_phoneNb)

Admits (#IP_ID, #F_ID)
