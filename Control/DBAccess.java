package Control;

import Model.Doctor;
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
                + ", " + p.getDate_Of_Birth() + ", '" + p.getFirst_Name() + "', '" +
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
        String query = "First_Name, Last_Name FROM DOCTOR WHERE specialty = " + specialty;
        ArrayList<String> DIDList = new ArrayList<>();
        try{
            connect();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                DIDList.add(res.getString("First_Name" + "Last_Name"));
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
    
    public ArrayList<Integer> getApptsIDFromDoctor(String doc){
        int DID = getIDFromName(doc);
        String q = "SELECT Appointment_ID FROM IS_AVAILABLE WHERE Doctor_ID = " + DID;
        ArrayList<Integer> ApptID = new ArrayList<>();
        
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            close();
            while (res.next())
                ApptID.add(res.getInt("Appointment_ID"));
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ApptID;
    }

    private int getIDFromName(String doc) {
        String[] fl = doc.split(" ");
        String fname = fl[0];
        String lname = fl[1];
        int DID = 0;
        String q = "SELECT Doctor_ID FROM DOCTOR WHERE First_Name = '" + fname 
                + "', AND Last_Name = '" + lname + "';";
       
        try{
            connect();
            ResultSet res = stmt.executeQuery(q);
            DID = res.getInt("Doctor_ID");
        }catch(SQLException ex){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DID;
    }
    
//    public ArrayList<String> getApptInfoFromID(int ID){
//        String q = "SELECT Day, Start_Time, End_Time"
//    }
}