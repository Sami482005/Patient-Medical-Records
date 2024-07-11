package Control;

import Model.Doctor;
import Model.Patient;
import java.sql.*;
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
//    
//    public void addNewDoctor(Doctor d){
//        String query = "INSERT INTO DOCTOR VALUES (" + d.getDoctorId() + ", '" + d.getFirstName() 
//                + "', '" +d.getLastName() + "', '" 
//    }
   
}
