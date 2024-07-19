package Model;

public class Book_Appointment{
    private Integer Patient_SSN;
    private Integer Appointment_ID;
    private String Reason;

    public Book_Appointment(){
        this.Patient_SSN = 0;
        this.Appointment_ID = 0;
        this.Reason = null;
    }

    public Book_Appointment(Integer Patient_SSN, Integer Appointment_ID, String Reason) {
        this.Patient_SSN = Patient_SSN;
        this.Appointment_ID = Appointment_ID;
        this.Reason = Reason;
    }

    public Integer getPatient_SSN() {
        return Patient_SSN;
    }

    public void setPatient_SSN(Integer Patient_SSN) {
        this.Patient_SSN = Patient_SSN;
    }

    public Integer getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(Integer Appointment_ID) {
        this.Appointment_ID = Appointment_ID;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
    
}