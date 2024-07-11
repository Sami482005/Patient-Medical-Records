package Model;

public class Covers_Test {
    private int insurancePlanId;
    private int testId;
    private float percentages;

    // Constructor
    public Covers_Test(int insurancePlanId, int testId, float percentages) {
        this.insurancePlanId = insurancePlanId;
        this.testId = testId;
        this.percentages = percentages;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public float getPercentages() {
        return percentages;
    }

    public void setPercentages(float percentages) {
        this.percentages = percentages;
    }
}
