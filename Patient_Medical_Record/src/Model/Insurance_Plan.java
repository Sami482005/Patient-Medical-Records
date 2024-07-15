package Model;


public class Insurance_Plan {
    private int insurancePlanId;
    private String companyProvider;
    private String insuranceClass;
    private String issuingDate;
    private String endDate;
    private int patientSSN;

    // Constructor
    public Insurance_Plan(){};
    public Insurance_Plan(int insurancePlanId, String companyProvider, String insuranceClass, String issuingDate, String endDate, int patientSSN) {
        this.insurancePlanId = insurancePlanId;
        this.companyProvider = companyProvider;
        this.insuranceClass = insuranceClass;
        this.issuingDate = issuingDate;
        this.endDate = endDate;
        this.patientSSN = patientSSN;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public String getCompanyProvider() {
        return companyProvider;
    }

    public void setCompanyProvider(String companyProvider) {
        this.companyProvider = companyProvider;
    }

    public String getInsuranceClass() {
        return insuranceClass;
    }

    public void setInsuranceClass(String insuranceClass) {
        this.insuranceClass = insuranceClass;
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }
}
