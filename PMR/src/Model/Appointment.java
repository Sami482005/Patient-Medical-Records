package Model;


public class Appointment {
    private int appointmentId;
    private String day;
    private String startTime;
    private String endTime;
    
    // Constructor
    public Appointment(int appointmentId, String day, String startTime, String endTime) {
        this.appointmentId = appointmentId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Appointment(){
        this.appointmentId = -3;
        this.day = null;
        this.startTime = null;
        this.endTime = null;
    }
    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
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
