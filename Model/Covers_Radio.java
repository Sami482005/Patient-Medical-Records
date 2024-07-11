package Model;

public class Covers_Radio {
    private int insurancePlanId;
    private int radiologyId;
    private float percentages;

    // Constructor
    public Covers_Radio(int insurancePlanId, int radiologyId, float percentages) {
        this.insurancePlanId = insurancePlanId;
        this.radiologyId = radiologyId;
        this.percentages = percentages;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public int getRadiologyId() {
        return radiologyId;
    }

    public void setRadiologyId(int radiologyId) {
        this.radiologyId = radiologyId;
    }

    public float getPercentages() {
        return percentages;
    }

    public void setPercentages(float percentages) {
        this.percentages = percentages;
    }
}
