package Control;

import Model.Appointment;
import Model.Book_Appointment;
import Model.Doctor;
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
    
    public ArrayList<Appointment> getApptInfoFromDoctor(String fn, String ln){
        String q = "SELECT * FROM APPOINTMENT WHERE Appointment_ID IN (SELECT Appointment_ID FROM IS_AVAILABLE NATURAL JOIN DOCTOR d WHERE d.First_Name = '" + fn + "', AND Last_Name = '" + ln + "';";
        Appointment appt = null;
        ArrayList<Appointment> appts = new ArrayList<>();
        
        try {
            connect();
            ResultSet res = stmt.executeQuery(q);
            if (res.next()){
                appt = new Appointment();
                appt.setAppointmentId(res.getInt("Appointment_ID"));
                appt.setDay(res.getString("Day"));
                appt.setStartTime(res.getString("Start_Time"));
                appt.setEndTime(res.getString("End_Time"));
                appts.add(appt);
            }
            close();
        }catch (SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appts;
    }

    public void removeApptFromAvailability(int appointmentId) {
        String q = "DELETE FROM IS_AVAILABLE WHERE Appointment_ID = " + appointmentId + ";";
        
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void addAppttoBookAppt(Book_Appointment a) {
        String q = "INSERT INTO BOOK_APPOINTMENT VALUES (" + a.getPatient_SSN()
                + ", " + a.getAppointment_ID() + ", '" + a.getReason() + "';";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Appointment> getApptFromSSN(int ssn) {
        String q = "SELECT * FROM APPOINTMENT NATURAL JOIN BOOK_APPOINTMENT WHERE Patient_SSN = " + ssn + ";";
        DBAccess d = new DBAccess();
        Appointment appt = null;
        ArrayList<Appointment> appts = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                appt = new Appointment();
                appt.setAppointmentId(res.getInt("Appointment_ID"));
                appt.setDay(res.getString("Day"));
                appt.setStartTime(res.getString("Start_Time"));
                appt.setEndTime(res.getString("End_Time"));
                appts.add(appt);
            }
            close();
        }catch(SQLException ex){
                Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appts;
    }   

    public void removeApptFromBooked(Appointment chosenAppointment) {
        String q = "DELETE FROM BOOK_APPOINTMENT WHERE Appointment_ID = " + chosenAppointment.getAppointmentId() + ";";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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

    public ArrayList<Surgeries> retrieveSurgeriesbyMRN(int mrn) {
        String q = "SELECT * FROM SURGERY NATURAL JOIN PERFORM_SURGERY NATUAL JOIN PATIENTS WHERE "
                + "Patient_ID = " + mrn + ";";
        ArrayList<Surgeries> sur = null;
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while (res.next()){
                Surgeries s = new Surgeries();
                s.setAim(res.getString("Aim"));
                s.setDate(res.getString("Date"));
                s.setDoctor_ID(res.getInt("Doctor_ID"));
                s.setPatient_ID(res.getInt("Patient_ID"));
                s.setSuccessful(res.getBoolean("Successful"));
                s.setSurgery_ID(res.getInt("Surgery_ID"));
                s.setSurgery_Name(res.getString("Surgery_Name"));
                sur.add(s);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                    
        }
        return sur;
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

    public ArrayList<Lab_Test> retrieveLabbyMRN(int mrnOfPatient) {
        String q = "SELECT * FROM LAB_TEST NATURAL JOIN MEDICAL_FILE NATURAL JOIN PATIENTS "
                + "WHERE Patient_ID = " + mrnOfPatient;
        ArrayList<Lab_Test> tests = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            while(res.next()){
                Lab_Test t = new Lab_Test();
                t.setDate(res.getString("Date"));
                t.setTestId(res.getInt("Test_ID"));
                t.setReason(res.getString("Reason"));
                t.setReport(res.getString("Report"));
                t.setTestName(res.getString("Test_Name"));
                tests.add(t);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                
        }
        return tests;
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
                rads.add(r);
            }
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                            
        }
        return rads;
    }

    public ArrayList<Treatment> retrieveTreatmentsbyMRN(int mrnOfPatient) {
        String q = "SELECT * FROM TREATMENT NATURAL JOIN MEDICAL_FILE NATURAL JOIN PATIENTS WHERE Patient_ID = " + mrnOfPatient + ";";
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

    public void createTheirMedicalFile(Patient p) {
        String q = "INSERT INTO MEDICAL_FILE (Medical_File_ID, Date_Of_Creation, Patient_SSN) " +
                   "VALUES (" + p.getPatient_ID() + ", '2024-07-22', '" + p.getPatient_SSN() + "');";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);                                                                        
        }

    }

    public void createApptInAppointment(Appointment a) {
        //should not insertt the value of the appointment_ID so u need to list the values being inserted and NOT NOT NOT INSERT THE APPOINTMENT_id DO NOT
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getDocIDFromApptID(int appointmentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    complete this please
    public void addAppttoAvailable(Appointment chosen, int doc_ID){
//        String q = "INSERT INTO IS_AVAILABLE VALUES (" + chosen.getAppointmentId() + ", 
//        try{
//            connect();
//            stmt.executeUpdate(q);
//            close();
//        }catch(SQLException ex){
//            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    //once ure done remove the comment
    //make sure u are always following the order of the attributes mentioneed in the sql queries file on github

    public int getDocIDFromDoc(Doctor d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Medical_Facility> getAllMedicalFacilities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Surgeries> getSurgeriesFromMRN(int mrnOfPatient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}