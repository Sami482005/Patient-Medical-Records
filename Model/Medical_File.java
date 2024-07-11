package Model;

import java.util.Date;

public class Medical_File {
    private int medicalFileId;
    private Date dateOfCreation;
    private int patientSSN;
    private int doctorId;
    private String prescription;
    private String description;
    private Date date;

    // Constructor
    public Medical_File(int medicalFileId, Date dateOfCreation, int patientSSN, int doctorId, String prescription, String description, Date date) {
        this.medicalFileId = medicalFileId;
        this.dateOfCreation = dateOfCreation;
        this.patientSSN = patientSSN;
        this.doctorId = doctorId;
        this.prescription = prescription;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public int getMedicalFileId() {
        return medicalFileId;
    }

    public void setMedicalFileId(int medicalFileId) {
        this.medicalFileId = medicalFileId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
