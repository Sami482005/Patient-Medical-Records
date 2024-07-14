package Model;

public class Has_Emergency_Contacts {
    private int patientSSN;
    private String phoneNumber;

    // Constructor
    public Has_Emergency_Contacts(int patientSSN, String phoneNumber) {
        this.patientSSN = patientSSN;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
