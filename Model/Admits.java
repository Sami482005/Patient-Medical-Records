package Model;

public class Admits {
    private int insurancePlanId;
    private int medicalFacilityId;

    // Constructor
    public Admits(int insurancePlanId, int medicalFacilityId) {
        this.insurancePlanId = insurancePlanId;
        this.medicalFacilityId = medicalFacilityId;
    }

    // Getters and Setters
    public int getInsurancePlanId() {
        return insurancePlanId;
    }

    public void setInsurancePlanId(int insurancePlanId) {
        this.insurancePlanId = insurancePlanId;
    }

    public int getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(int medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }
}
