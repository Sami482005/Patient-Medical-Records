package Model;

public class Covers_Treatment {
    private int insurancePlanId;
    private int treatmentId;
    private double percentages;

    // Constructor
    public Covers_Treatment(int insurancePlanId, int treatmentId, double percentages) {
        this.insurancePlanId = insurancePlanId;
        this.treatmentId = treatmentId;
        this.percentages = percentages;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public double getPercentages() {
        return percentages;
    }

    public void setPercentages(double percentages) {
        this.percentages = percentages;
    }
}
