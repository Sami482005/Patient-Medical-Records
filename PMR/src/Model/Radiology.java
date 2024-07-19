package Model;


public class Radiology {
    private int radiologyId;
    private String radiologyName;
    private String date;
    private String report;
    private String reason;
    private int medicalFileId;

    // Constructor
    public Radiology(){};
    public Radiology(int radiologyId, String radiologyName, String date, String report, String reason, int medicalFileId) {
        this.radiologyId = radiologyId;
        this.radiologyName = radiologyName;
        this.date = date;
        this.report = report;
        this.reason = reason;
        this.medicalFileId = medicalFileId;
    }

    // Getters and Setters
    public int getRadiologyId() {
        return radiologyId;
    }

    public void setRadiologyId(int radiologyId) {
        this.radiologyId = radiologyId;
    }

    public String getRadiologyName() {
        return radiologyName;
    }

    public void setRadiologyName(String radiologyName) {
        this.radiologyName = radiologyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMedicalFileId() {
        return medicalFileId;
    }

    public void setMedicalFileId(int medicalFileId) {
        this.medicalFileId = medicalFileId;
    }
}
