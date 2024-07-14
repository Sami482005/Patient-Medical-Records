package Model;

public class Covers_Surgery {
    private int insurancePlanId;
    private int surgeryId;
    private double percentages;

    // Constructor
    public Covers_Surgery(int insurancePlanId, int surgeryId, double percentages) {
        this.insurancePlanId = insurancePlanId;
        this.surgeryId = surgeryId;
        this.percentages = percentages;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public int getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }

    public double getPercentages() {
        return percentages;
    }

    public void setPercentages(double percentages) {
        this.percentages = percentages;
    }
}
