package Model;

import java.util.Date;

public class Treatment {
    private int treatmentId;
    private String treatmentName;
    private String reason;
    private Date startDate;
    private Date endDate;
    private int medicalFileId;

    // Constructor
    public Treatment(int treatmentId, String treatmentName, String reason, Date startDate, Date endDate, int medicalFileId) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.medicalFileId = medicalFileId;
    }

    // Getters and Setters
    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMedicalFileId() {
        return medicalFileId;
    }

    public void setMedicalFileId(int medicalFileId) {
        this.medicalFileId = medicalFileId;
    }
}
