package Model;


public class Lab_Test {
    private int testId;
    private String testName;
    private String date;
    private String report;
    private String reason;
    private int medicalFileId;

    // Constructor
    public Lab_Test(){};
    public Lab_Test(int testId, String testName, String date, String report, String reason, int medicalFileId) {
        this.testId = testId;
        this.testName = testName;
        this.date = date;
        this.report = report;
        this.reason = reason;
        this.medicalFileId = medicalFileId;
    }

    // Getters and Setters
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
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
