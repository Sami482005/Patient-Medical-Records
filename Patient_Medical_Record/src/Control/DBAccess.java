package Control;

import Model.Appointment;
import Model.Book_Appointment;
import Model.Doctor;
import Model.Insurance_Plan;
import Model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAccess {
    private Connection con;
    private Statement stmt;
    
    private void connect() throws SQLException{
        con= DriverManager.getConnection("jdbc:mysql://localhost/pmr", "root", "");
        stmt=con.createStatement();
    }
    
    private void close() throws SQLException{
        stmt.close();
        con.close();
    }
    
    public void addNewPatient(Patient p){
        String query = "INSERT INTO PATIENT VALUES (" + p.getPatient_SSN() + ", " + p.getPatient_ID()
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
    
    public void addAppttoAvailable(Appointment chosen){
        String q = "INSERT INTO IS_AVAILABLE VALUES (" + chosen.getAppointmentId() + ", '" + chosen.getDay()
                + "', '" + chosen.getStartTime() + "', '" + chosen.getEndTime() + "';";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean exists(int SSN){
        String q = "SELECT * FROM PATIENTS WHERE Patient_SSN = " + SSN;
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
                + ", '" + ip.getCompanyProvider() + "', '" + ip.getClass()
                + "', '" + ip.getIssuingDate() + "', '" + ip.getEndDate()
                + "', " + ip.getPatientSSN() + ";";
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void updateMedicalHistory(int MRN, String MedHis){
        String q = "UPDATE PATIENTS SET Medical_History = " + MedHis
                + "WHERE Patient_ID = " + MRN;
        try{
            connect();
            stmt.executeUpdate(q);
            close();
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public int getSSNFromMRN(int MRNs) {
        String q = "SELECT Patient_SSN FROM PATIENTS WHERE Patient_ID = " + MRNs;
        int SSNN = 10;
        try{
            connect();
            ResultSet id = stmt.executeQuery(q);
            SSNN = id.getInt("Patient_ID");
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
                + ", Patient_ID = " + p.getPatient_ID() + ", Date = '" + p.getDate_Of_Birth()
                + "', First_Name = '" + p.getFirst_Name() + "', Last_Name = " + 
                p.getLast_Name() + "', email = '" + p.getEmail() + "', Phone_Number = '" +
                p.getPhone_Number() + "', Address = '" + p.getAddress() + "', Gender = '"
                + p.getGender() + "';";
        


    }
}