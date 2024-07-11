package Model;

import java.util.Date;

public class Insurance_Plan {
    private int insurancePlanId;
    private String companyProvider;
    private String insuranceClass;
    private Date issuingDate;
    private Date endDate;
    private int patientSSN;

    // Constructor
    public Insurance_Plan(int insurancePlanId, String companyProvider, String insuranceClass, Date issuingDate, Date endDate, int patientSSN) {
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

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }
}
