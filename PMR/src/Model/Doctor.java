package Model;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;
    private String specialty;
    private int startingYear;
    private int medicalFacilityId;

    // Constructor
    public Doctor(){};
    
    public Doctor(int doctorId, String firstName, String lastName, String email, String phoneNumber, String title, String specialty, int startingYear, int medicalFacilityId) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.specialty = specialty;
        this.startingYear = startingYear;
        this.medicalFacilityId = medicalFacilityId;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(int startingYear) {
        this.startingYear = startingYear;
    }

    public int getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(int medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }
}
