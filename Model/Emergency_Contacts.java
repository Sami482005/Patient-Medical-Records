package Model;

public class Emergency_Contacts {
    private String phoneNumber;
    private String name;
    private String relationship;

    // Constructor
    public Emergency_Contacts(String phoneNumber, String name, String relationship) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.relationship = relationship;
    }

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
