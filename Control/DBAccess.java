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

    ppublic void addNewDoctor(Doctor d) {
        String query = "INSERT INTO DOCTOR VALUES (" + d.getDoctorId() + ", '" + d.getFirstName() 
                + "', '" + d.getLastName() + "', '" + d.getEmail() + "', '" + d.getPhoneNumber() 
                + "', '" + d.getTitle() + "', '" + d.getSpecialty() + "', " + d.getStartingYear() 
                + ", " + d.getFID() + ")";
        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getDoctorsBySpecialty(String specialty) throws SQLException {
        String query = "SELECT first_name, last_name FROM DOCTOR WHERE specialty = ?";
        connect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, specialty);
        return pstmt.executeQuery();
    }

    public ResultSet getDoctorByIdOrName(int doctorId, String firstName, String lastName) throws SQLException {
        String query = "SELECT * FROM DOCTOR WHERE doctor_id = ? OR (first_name = ? AND last_name = ?)";
        connect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, doctorId);
        pstmt.setString(2, firstName);
        pstmt.setString(3, lastName);
        return pstmt.executeQuery();
    }

    public ResultSet getPatientById(int patientId) throws SQLException {
        String query = "SELECT * FROM PATIENT WHERE patient_id = ?";
        connect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, patientId);
        return pstmt.executeQuery();
    }
}
// Method to retrieve appointments by doctor ID
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointments WHERE Doctor_ID = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("Appointment_ID"));
                appointment.setDoctorId(rs.getInt("Doctor_ID"));
                appointment.setPatientId(rs.getInt("Patient_ID"));
                appointment.setAppointmentDate(rs.getDate("Appointment_Date"));
                // Set other appointment details as needed
                
                appointments.add(appointment);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return appointments;
    }

   
    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
