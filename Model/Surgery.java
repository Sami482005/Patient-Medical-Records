package Model;

import java.util.Date;

public class Surgery {
    private int surgeryId;
    private String surgeryName;
    private Date date;
    private String aim;

    // Constructor
    public Surgery(int surgeryId, String surgeryName, Date date, String aim) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }
}
