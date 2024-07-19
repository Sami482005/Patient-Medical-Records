package Model;


public class Perform_Surgery {
    private int doctorId;
    private int medicalFacilityId;
    private int patientSSN;
    private int surgeryId;
    private float price;
    private boolean successful;
    private String date;

    // Constructor
    public Perform_Surgery(){};
    public Perform_Surgery(int doctorId, int medicalFacilityId, int patientSSN, int surgeryId, float price, boolean successful, String date) {
        this.doctorId = doctorId;
        this.medicalFacilityId = medicalFacilityId;
        this.patientSSN = patientSSN;
        this.surgeryId = surgeryId;
        this.price = price;
        this.successful = successful;
        this.date = date;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(int medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }

    public int getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
