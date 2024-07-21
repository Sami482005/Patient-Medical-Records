package Control;

import Model.Appointment;
import Model.Doctor;
import Model.Emergency_Contacts;
import Model.Insurance_Plan;
import Model.Lab_Test;
import Model.Medical_Facility;
import Model.Patient;
import Model.Perform_Surgery;
import Model.Radiology;
import Model.Surgeries;
import Model.Surgery;
import Model.Treatment;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAccess {
    private Connection con;
    private Statement stmt;
    
    private void connect() throws SQLException{
        con= DriverManager.getConnection("jdbc:mysql://localhost/patient medical records", "root", "");
        stmt=con.createStatement();
    }
    
    private void close() throws SQLException{
        stmt.close();
        con.close();
    }
    
    public void addNewPatient(Patient p){
        String query = "INSERT INTO PATIENTS VALUES (" + p.getPatient_SSN() + ", " + p.getPatient_ID()
                + ", '" + p.getDate_Of_Birth() + "', '" + p.getFirst_Name() + "', '" +
                p.getLast_Name() + "', '" + p.getEmail() +"', '" + p.getPhone_Number()
                + "', '" + p.getAddress() + "', '" + p.getGender() + "', '" +
                p.getMedical_History() + "')";
        try{
            connect();
            stmt.executeUpdate(query);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void addNewDoctor(Doctor d) {
        String query = "INSERT INTO DOCTOR VALUES (" + d.getDoctorId() + ", '" + d.getFirstName() 
                + "', '" + d.getLastName() + "', '" + d.getEmail() + "', '" + d.getPhoneNumber() 
                + "', '" + d.getTitle() + "', '" + d.getSpecialty() + "', " + d.getStartingYear() 
                + ", " + d.getMedicalFacilityId()+ ")";
        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getDoctorsBySpecialty(String specialty) throws SQLException {
        String query = "SELECT First_Name, Last_Name FROM DOCTOR WHERE specialty = " + specialty;
        ArrayList<String> DIDList = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                DIDList.add(res.getString("First_Name" + " " + "Last_Name"));
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DIDList;
    }
    
    public ArrayList<String> getAllSpecialties() throws SQLException{
        String q = "SELECT Specialty FROM DOCTOR";
        ArrayList<String> specialties = new ArrayList<>();
        
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while(res.next()){
                specialties.add(res.getString("Specialty"));
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return specialties;
    }
    
//    public void removeApptFromAvailability(Appointment a) {
//        String q = "DELETE FROM IS_AVAILABLE WHERE Appointment_ID = " + a.getAppointmentId() + ";";
//        
//        try{
//            connect();
//            stmt.executeUpdate(q);
//            close();
//        }catch(SQLException ex){
//            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//    }
    
    public boolean exists(int SSN){
        String q = "SELECT * FROM PATIENTS WHERE Patient_SSN = " + SSN + ";";
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (!res.next())
                return false;
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public void createNewInsurancePlan(Insurance_Plan ip) {
        String q = "INSERT INTO INSURANCE_PLAN VALUES (" + ip.getInsurancePlanId()
                + ", '" + ip.getCompanyProvider() + "', '" + ip.getInsuranceClass()
                + "', '" + ip.getIssuingDate() + "', '" + ip.getEndDate()
                + "', " + ip.getPatientSSN() + ");";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void updateMedicalHistory(int MRN, String MedHis){
        String q = "UPDATE PATIENTS SET Medical_History = '" + MedHis
                + "' WHERE Patient_ID = " + MRN;
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public int getSSNFromMRN(int MRNs) {
        String q = "SELECT Patient_SSN FROM PATIENTS WHERE Patient_ID = " + MRNs + ";";
        int SSNN = 0;
        try{
            connect();
            ResultSet id = stmt.executeQuery(q);
            if (id.next())
                SSNN = id.getInt("Patient_SSN");
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SSNN;
    }

    public Patient getPatientFromMRN(int MRN) {
        String q = "SELECT * FROM PATIENTS WHERE Patient_ID = " + MRN;
        Patient p = null;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                p = new Patient();
                p.setPatient_SSN(res.getInt("Patient_SSN"));
                p.setPatient_ID(MRN);
                p.setDate_Of_Birth(res.getString("Date_Of_Birth"));
                p.setFirst_Name(res.getString("First_Name"));
                p.setLast_Name(res.getString("Last_Name"));
                p.setEmail(res.getString("email"));
                p.setPhone_Number(res.getString("Phone_Number"));
                p.setAddress(res.getString("Address"));
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void updatePatientBySSN(Patient p) {
        String q = "UPDATE PATIENTS SET Patient_SSN = " + p.getPatient_SSN()
                + ", Patient_ID = " + p.getPatient_ID() + ", Date_Of_Birth = '" + p.getDate_Of_Birth()
                + "', First_Name = '" + p.getFirst_Name() + "', Last_Name = '" + 
                p.getLast_Name() + "', email = '" + p.getEmail() + "', Phone_Number = '" +
                p.getPhone_Number() + "', Address = '" + p.getAddress() + "', Gender = '"
                + p.getGender() + "' "
                + "WHERE Patient_SSN = " + p.getPatient_SSN() + ";";
        
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }

    }

    public Insurance_Plan getInsuranceInfoFromMRN(int mrn) {
        String q = "SELECT * FROM INSURANCE_PLAN WHERE Patient_SSN = "
                + "(SELECT PATIENT_SSN FROM PATIENTS WHERE PATIENT_ID = " + mrn
                + ");";
        Insurance_Plan ip = null;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                ip = new Insurance_Plan();
                ip.setInsurancePlanId(res.getInt("Insurance_Plan_ID"));
                ip.setCompanyProvider(res.getString("Company_Provider"));
                ip.setInsuranceClass(res.getString("Class"));
                ip.setIssuingDate(res.getString("Issuing_Date"));
                ip.setEndDate(res.getString("End_Date"));
                ip.setPatientSSN(res.getInt("Patient_SSN"));
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return ip;
    }

    public void UpdateInsurancePlan(Insurance_Plan ip) {
        String q = "UPDATE INSURANCE_PLAN SET Insurance_Plan_ID = " + ip.getInsurancePlanId()
                + ", Company_Provider = '" + ip.getCompanyProvider()
                + "', Class = '" + ip.getInsuranceClass() + "', Issuing_Date = '"
                + ip.getIssuingDate() + "', End_Date = '" + ip.getEndDate() + "', Patient_SSN = "
                + ip.getPatientSSN()
                + " WHERE Insurance_Plan_ID = " + ip.getInsurancePlanId() + ";"; 

        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    public Perform_Surgery getPerformFromSurgery(Surgery s) {
        String q = "SELECT * FROM PERFORM_SURGERY WHERE Surgery_ID = "
                + "(SELECT SURGERY_ID FROM SURGERY WHERE SURGERY_ID = "
                + s.getSurgeryId();
        Perform_Surgery su = null;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if(res.next()){
                su = new Perform_Surgery();
                su.setDoctorId(res.getInt("Doctor_ID"));
                su.setMedicalFacilityId(res.getInt("Medical_Facility_ID"));
                su.setPatientSSN(res.getInt("Patient_SSN"));
                su.setSurgeryId(res.getInt("Surgery_ID"));
                su.setSuccessful(res.getBoolean("Successful"));
                su.setDate(res.getString("Date"));
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                        
        }
        return su;
    }

    public int getMRNFromSSN(Patient p) {
        String q = "SELECT Patient_ID FROM PATIENTS WHERE Patient_SSN = " + p.getPatient_SSN() + ";";
        int MRN = 0;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next())
                MRN = res.getInt("Patient_ID");
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                    
        }
        return MRN;
    }

    

    public ArrayList<Radiology> retrieveRadiologybyMRN(int mrnOfPatient) {
        String q = "SELECT * FROM RADIOLOGY NATURAL JOIN MEDICAL_FILE  WHERE MEDICAL_FILE_ID = " + mrnOfPatient + ";";
        ArrayList<Radiology> rads = new ArrayList<>();
        
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                Radiology r = new Radiology();
                r.setRadiologyId(res.getInt("Radiology_ID"));
                r.setRadiologyName(res.getString("Radiology_Name"));
                r.setReport(res.getString("Report"));
                r.setReason(res.getString("Reason"));
                r.setDate(res.getString("Date"));
                rads.add(r);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                            
        }
        return rads;
    }

    public ArrayList<Treatment> retrieveTreatmentsbyMRN(int mrnOfPatient) {
        String q = "SELECT * FROM TREATMENT NATURAL JOIN MEDICAL_FILE WHERE Medical_File_ID = " + mrnOfPatient + ";";
        ArrayList<Treatment> treat = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                Treatment t = new Treatment();
                t.setTreatmentId(res.getInt("Treatment_ID"));
                t.setTreatmentName(res.getString("Treatment_Name"));
                t.setReason(res.getString("Reason"));
                t.setStartDate(res.getString("Start_Date"));
                t.setEndDate(res.getString("End_Date"));
                treat.add(t);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return treat;
    }

    public String retrievePrescriptionFromMedicalFile(int mrnOfPatient) {
        String q = "SELECT Prescription FROM MEDICAL_FILE NATURAL JOIN PATIENTS WHERE "
                + "Patient_ID = " + mrnOfPatient + ";";
        String s = "";
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                s = res.getString("Prescription");
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                            
        }
        return s;
    }

    public void createTheirMedicalFile(int MRN, Patient p) {
        String q = "INSERT INTO MEDICAL_FILE (Medical_File_ID, Patient_SSN) " +
                   "VALUES (" + MRN + ", " + p.getPatient_SSN() + ");";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                                        
        }

    }

    public void createApptInAppointment(Appointment a) {
    String q = "INSERT INTO APPOINTMENT (Day, Start_Time, End_Time) VALUES ('" 
            + a.getDay() + "', '" + a.getStartTime() + "', '" + a.getEndTime() + "');";
    try {
        connect();
        stmt.executeUpdate(q);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public int NewApptID(){
        String q = "SELECT MAX(Appointment_ID) AS Appointment_ID FROM APPOINTMENT";
        int ap = 0;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next())
                ap = res.getInt("Appointment_ID");
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return ap;
    }
public int getDocIDFromApptID(int appointmentId) {
    String q = "SELECT Doctor_ID FROM IS_AVAILABLE WHERE Appointment_ID = " + appointmentId + ";";
    int doctorId = 0;
    try {
        connect();
        ResultSet res = stmt.executeQuery(q);
        if (res.next())
            doctorId = res.getInt("Doctor_ID");
        
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return doctorId;
}

public void addAppttoAvailable(int chosen, int doc_ID) {
    String q = "INSERT INTO IS_AVAILABLE (Appointment_ID, Doctor_ID) VALUES (" 
            + chosen + ", " + doc_ID + ");";
    try {
        connect();
        stmt.executeUpdate(q);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
}

public int getDocIDFromDoc(Doctor d) {
    String q = "SELECT Doctor_ID FROM DOCTOR WHERE First_Name = '" + d.getFirstName() 
            + "' AND Last_Name = '" + d.getLastName() + "'";
    int doctorId = 0;
    try {
        connect();
        ResultSet res = stmt.executeQuery(q);
        if (res.next()) {
            doctorId = res.getInt("Doctor_ID");
        }
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return doctorId;
}

public ArrayList<Medical_Facility> getAllMedicalFacilities() {
    String q = "SELECT * FROM MEDICAL_FACILITY";
    ArrayList<Medical_Facility> facilities = new ArrayList<>();
    try {
        connect();
        ResultSet res = stmt.executeQuery(q);
        while (res.next()) {
            Medical_Facility facility = new Medical_Facility();
            facility.setMedical_Facility_ID(res.getInt("Medical_Facility_ID"));
            facility.setFacility_Name(res.getString("Facility_Name"));
            facility.setFacility_Location(res.getString("Facility_Location"));
            facilities.add(facility);
        }
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return facilities;
}

public ArrayList<Surgeries> getSurgeriesFromSSN(int SSnOfPatient) {
String q = "SELECT * FROM SURGERY NATURAL JOIN PERFORM_SURGERY WHERE Patient_SSN = " + SSnOfPatient + ";";
    ArrayList<Surgeries> surgeries = new ArrayList<>();
    try {
        connect();
        ResultSet res = stmt.executeQuery(q);
        while (res.next()) {
            Surgeries surgery = new Surgeries();
            surgery.setSurgery_ID(res.getInt("Surgery_ID"));
            surgery.setSurgery_Name(res.getString("Surgery_Name"));
            surgery.setAim(res.getString("Aim"));
            surgery.setDate(res.getString("Date"));
            surgery.setDoctor_ID(res.getInt("Doctor_ID"));
            surgery.setSuccessful(res.getBoolean("Successful"));
            surgeries.add(surgery);
        }
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
    return surgeries;
}

public void createNewRadiologyOnMedicalFile(int patientMRN, Radiology r) {
    String q = "INSERT INTO RADIOLOGY (Radiology_Name, Date, Report, Reason, Medical_File_ID) VALUES ('"
        + r.getRadiologyName() + "', '" 
        + r.getDate() + "', '" 
        + r.getReport() + "', '" 
        + r.getReason() + "', " 
        + patientMRN + ");";
    try {
        connect();
        stmt.executeUpdate(q);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void addNewSurgery(int patientMRN, Surgeries s) {
   String q = "INSERT INTO PERFORM_SURGERY(Doctor_ID, Patient_SSN, Successful, Date) VALUES (" 
            + s.getDoctor_ID() + ", " 
            + getSSNFromMRN(patientMRN) + ", " 
            + s.isSuccessful() + ", '" 
            + s.getDate() + "');";
   String q1 = "INSERT INTO SURGERY  VALUES (" + getMaxSurgeryIDFromPerform_Surgery() + ", '"
            + s.getSurgery_Name() + "', '" 
            + s.getAim() + "');";
    try {
        connect();
        stmt.executeUpdate(q);
        stmt.executeUpdate(q1);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void addNewTreatment(int patientMRN, Treatment t) {
    String q = "INSERT INTO TREATMENT VALUES (" + t.getTreatmentId() + ", '"
            + t.getTreatmentName() + "', '" 
            + t.getReason() + "', '" 
            + t.getStartDate() + "', '" 
            + t.getEndDate() + "', " 
            + patientMRN + ");";
    try {
        connect();
        stmt.executeUpdate(q);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
}

public void addNewLabTest(int patientMRN, Lab_Test l) {
    String q = "INSERT INTO LAB_TEST (Test_Name, Date, Report, Reason, Medical_File_ID) VALUES ('"
            + l.getTestName() + "', '" 
            + l.getDate() + "', '" 
            + l.getReport() + "', '" 
            + l.getReason() + "', " 
            + patientMRN + ")";
    try {
        connect();
        stmt.executeUpdate(q);
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public ArrayList<Lab_Test> getLabTestsOfPatientsByMRN(int patientMRN) {
    String q = "SELECT * FROM LAB_TEST WHERE Medical_File_ID = " + patientMRN;
    ArrayList<Lab_Test> labTests = new ArrayList<>();
    try {
        connect();
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            Lab_Test labTest = new Lab_Test();
            labTest.setTestId(rs.getInt("Test_ID"));
            labTest.setTestName(rs.getString("Test_Name"));
            labTest.setDate(rs.getString("Date"));
            labTest.setReport(rs.getString("Report"));
            labTest.setReason(rs.getString("Reason"));
            labTest.setMedicalFileId(rs.getInt("Medical_File_ID"));
            labTests.add(labTest);
        }
        close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return labTests;
}

   public void updateMedicalFileWithNewPrescriptionUsingMRN(int patientMRN, String prescription) {
        String q = "UPDATE MEDICAL_FILE SET Prescription = '" + prescription + "' WHERE Medical_File_ID = " + patientMRN;
        try {
            connect();
            stmt.executeUpdate(q);
        close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    public void addEmergencyContactToMRN(Emergency_Contacts ec, int mrnOfPatient) {
    String q = "INSERT INTO EMERGENCY_CONTACTS VALUES ('"
            + ec.getPhoneNumber() + "', '"
            + ec.getName() + "', '"
            + ec.getRelationship() + "', "
            + getSSNFromMRN(mrnOfPatient) + ");";
    try {
        connect();
        stmt.executeUpdate(q);
    close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
}

    public ArrayList<Appointment> getApptsBySpecialty(String chosenSpecialty) {
        String q = "SELECT * FROM APPOINTMENT a "
               + "NATURAL JOIN IS_AVAILABLE "
               + "NATURAL JOIN DOCTOR "
               + "WHERE Specialty = '" + chosenSpecialty + "' "
               + "AND a.Patient_SSN IS NULL;";
        ArrayList<Appointment> appts = new ArrayList<>();
        
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                Appointment a = new Appointment();
                a.setAppointmentId(res.getInt("Appointment_ID"));
                a.setDay(res.getString("Day"));
                a.setEndTime(res.getString("End_Time"));
                a.setPatient_SSN(res.getInt("Patient_SSN"));
                a.setReason(res.getString("Reason"));
                a.setStartTime(res.getString("Start_Time"));
                appts.add(a);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appts;
    }

    public ArrayList<Appointment> getApptFromSSN(int SSN) {
        String q = "SELECT * FROM APPOINTMENT WHERE Patient_SSN = " + SSN + ";";
        ArrayList<Appointment> aps = null;
        
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                aps = new ArrayList<>();
                Appointment a = new Appointment();
                a.setAppointmentId(res.getInt("Appointment_ID"));
                a.setDay(res.getString("Day"));
                a.setEndTime(res.getString("End_Time"));
                a.setPatient_SSN(SSN);
                a.setReason(res.getString("Reason"));
                a.setStartTime(res.getString("Start_Time"));
                aps.add(a);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aps;
    }

    public void updateAppointment(Appointment a) {
        String q = "UPDATE APPOINTMENT SET Patient_SSN = NULL, REASON = NULL WHERE Appointment_ID = " + a.getAppointmentId() + ";";
        try {
        connect();
        stmt.executeUpdate(q);
    close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }

    public ArrayList<Appointment> getBookedAppointments(int DocID) {
        String q = "SELECT * " +
                    "FROM APPOINTMENT " +
                    "NATURAL JOIN IS_AVAILABLE " +
                    "WHERE Doctor_ID = " + DocID + " AND Patient_SSN IS NOT NULL;";
        ArrayList<Appointment> appts = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while(res.next()){
                Appointment a = new Appointment();
                a.setDay(res.getString("Day"));
                a.setEndTime(res.getString("End_Time"));
                a.setStartTime(res.getString("Start_Time"));
                a.setAppointmentId(res.getInt("Appointment_ID"));
                appts.add(a);
            }
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return appts;
    }

    public Patient getPatientFromAppt(Appointment ap) {
        String q = "SELECT p.First_Name, p.Last_Name, p.Patient_ID " +
               "FROM PATIENTS p " +
               "NATURAL JOIN APPOINTMENT a " +
               "WHERE a.Appointment_ID = " + ap.getAppointmentId() + ";";
        Patient p = null;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if(res.next()){
                p = new Patient();
                p.setPatient_ID(res.getInt("Patient_ID"));
                p.setLast_Name(res.getString("Last_Name"));
                p.setFirst_Name(res.getString("First_Name"));
            }
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return p;
    }

    public boolean EnsureEmail(int iDofDoctor, String email) {
        String q = "SELECT email FROM DOCTOR WHERE Doctor_ID = " + iDofDoctor + ";";
        String em = "";
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                em = res.getString("email");
            }
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                        
        }
        return em.equals(email);
    }

    public boolean EnsureEmailofPatient(int parseInt, String email) {
String q = "SELECT email FROM PATIENTS WHERE Patient_ID = " + parseInt + ";";
        String em = "";
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                em = res.getString("email");
            }
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                        
        }
        return em.equals(email);
    }

    public void bookAppt(Appointment a) {
        String q = "UPDATE APPOINTMENT SET Patient_SSN = " + a.getPatient_SSN() + ", REASON = '" + a.getReason() + "' WHERE  Appointment_ID = " + a.getAppointmentId();
           try {
        connect();
        stmt.executeUpdate(q);
    close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    public ArrayList<Doctor> getDoctors() {
        String query = "SELECT * FROM DOCTOR;";
        ArrayList<Doctor> DIDList = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                Doctor d = new Doctor();
                d.setDoctorId(res.getInt("Doctor_ID"));
                d.setFirstName(res.getString("First_Name"));
                d.setLastName(res.getString("Last_Name")); 
                DIDList.add(d);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DIDList;
    }

    public void addDRtoMedicalFile(int mrnOfPatient, int chosenDR) {
        String q = "UPDATE MEDICAL_FILE SET Doctor_ID = " + chosenDR 
               + " WHERE Medical_File_ID = " + mrnOfPatient + ";";
        try {
        connect();
        stmt.executeUpdate(q);
    close();
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    private int getMaxSurgeryIDFromPerform_Surgery() {
        String q = "SELECT MAX(Surgery_ID) AS ID FROM PERFORM_SURGERY;";
        int id = -1;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next())
                id = res.getInt("ID");
            close();
        }catch(SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return id;
    }
}