package Model;


public class Appointment {
    private int appointmentId;
    private String day;
    private String startTime;
    private String endTime;
    private int Patient_SSN;
    private String reason;
    
    // Constructor
    public Appointment(){
    }
    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPatient_SSN() {
        return Patient_SSN;
    }

    public void setPatient_SSN(int Patient_SSN) {
        this.Patient_SSN = Patient_SSN;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        String s = "Appointment_ID: " + getAppointmentId();
        s += "Day: " + getDay();
        s += "At: " + getStartTime();
        s += "Till: " + getEndTime();
        return s;
    }
}
