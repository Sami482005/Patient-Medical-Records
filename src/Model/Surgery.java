package Model;


public class Surgery {
    private int surgeryId;
    private String surgeryName;
    private String date;
    private String aim;

    // Constructor
    public Surgery(){};
    public Surgery(int surgeryId, String surgeryName, String date, String aim) {
        this.surgeryId = surgeryId;
        this.surgeryName = surgeryName;
        this.date = date;
        this.aim = aim;
    }

    // Getters and Setters
    public int getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }
}
