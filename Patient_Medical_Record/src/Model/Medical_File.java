package Model;


public class Medical_File {
    private int medicalFileId;
    private int patientSSN;
    private int doctorId;
    private String prescription;
    private String description;
    private String UpdateDate ;

    // Constructor
    public Medical_File(int medicalFileId, int patientSSN, int doctorId, String prescription, String description, String UpdateDate) {
        this.medicalFileId = medicalFileId;
        this.patientSSN = patientSSN;
        this.doctorId = doctorId;
        this.prescription = prescription;
        this.description = description;
        this.UpdateDate = UpdateDate;
    }

    // Getters and Setters
    public int getMedicalFileId() {
        return medicalFileId;
    }

    public void setMedicalFileId(int medicalFileId) {
        this.medicalFileId = medicalFileId;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

}
