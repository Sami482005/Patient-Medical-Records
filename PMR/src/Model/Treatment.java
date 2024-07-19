package Model;


public class Treatment {
    private int treatmentId;
    private String treatmentName;
    private String reason;
    private String startDate;
    private String endDate;
    private int medicalFileId;

    // Constructor
    public Treatment(){};
    public Treatment(int treatmentId, String treatmentName, String reason, String startDate, String endDate, int medicalFileId) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMedicalFileId() {
        return medicalFileId;
    }

    public void setMedicalFileId(int medicalFileId) {
        this.medicalFileId = medicalFileId;
    }
}
