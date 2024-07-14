package Model;

public class Is_Available {
    private int doctorId;
    private int appointmentId;

    // Constructor
    public Is_Available(int doctorId, int appointmentId) {
        this.doctorId = doctorId;
        this.appointmentId = appointmentId;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
}
