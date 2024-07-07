MedicalFacility (F_ID, Fname, location, contactInfo)

Doctor (Doctor-ID, first-name, last-name, email, phone_nb, title, office_nb, specialty, starting_Year #F_ID)

Patients (P_SSN, P_ID, DOB, first-name, last-name, address, gender, email, phone_nb, medical_history)

InsurancePlan (IP_ID, class, company_provider, issuing_date, end_date, #P_ID)

EmergencyContacts (phone_nb, name, relationship)

Medical_File (MF_ID, dateOfcreation, #P_SSN, #Doctor-ID, prescription, desc, date)

LabTest (LT_ID, report, type, reason, #MF_ID)

Radiology (R_ID, type, report, reason, imagesFiles, #MF_ID)

Surgery (S_ID, Surgery_name, aim)

Treatments (T_ID, name, reason, startDate, endDate, #MF_ID)

Appointment (A_ID, day, to, from, reasonOfvisit, statusOfappt, #P_SSN)

Perform_Surgery (#Doctor_ID, #Facility_ID, #P_SSN, #Surgery_ID, price, successful?, Date)

hasAvailability (#Doctor_ID, #Availability_ID)

CoversSurgery (#Surgery_ID, #InsurancePlan_ID, Percentage)

CoversTreatment (#T_ID, #IP_ID, percentage)

CoversRadio (#IP_ID, #R_ID, percentage)

CoversTest (#IP_ID, #LT_ID, percentage)

Has_Emergency_Contacts ( #P_SSN, #EC_phoneNb)

Admits (#IP_ID, #F_ID)