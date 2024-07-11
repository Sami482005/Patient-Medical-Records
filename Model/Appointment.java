package Model;

import java.time.LocalTime;

public class Appointment {
    private int appointmentId;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private int patientSSN;
    private String reason;
    private String statusOfAppointment;

    // Constructor
    public Appointment(int appointmentId, String day, LocalTime startTime, LocalTime endTime, int patientSSN, String reason, String statusOfAppointment) {
        this.appointmentId = appointmentId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patientSSN = patientSSN;
        this.reason = reason;
        this.statusOfAppointment = statusOfAppointment;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatusOfAppointment() {
        return statusOfAppointment;
    }

    public void setStatusOfAppointment(String statusOfAppointment) {
        this.statusOfAppointment = statusOfAppointment;
    }
}
