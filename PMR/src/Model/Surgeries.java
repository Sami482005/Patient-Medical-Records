package Model;

public class Surgeries {
    private String Surgery_Name;
    private int Surgery_ID;
    private String Aim;
    private int Doctor_ID;
    private String Date;
    private boolean Successful;
    private int Patient_ID;
    private int Price;

    public Surgeries() {
    }

    public Surgeries(String Surgery_Name, int Surgery_ID, String Aim, int Doctor_ID, String Date, boolean Successful, int Patient_ID, int Price) {
        this.Surgery_Name = Surgery_Name;
        this.Surgery_ID = Surgery_ID;
        this.Aim = Aim;
        this.Doctor_ID = Doctor_ID;
        this.Date = Date;
        this.Successful = Successful;
        this.Patient_ID = Patient_ID;
        this.Price = Price;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getSurgery_Name() {
        return Surgery_Name;
    }

    public void setSurgery_Name(String Surgery_Name) {
        this.Surgery_Name = Surgery_Name;
    }

    public int getSurgery_ID() {
        return Surgery_ID;
    }

    public void setSurgery_ID(int Surgery_ID) {
        this.Surgery_ID = Surgery_ID;
    }

    public String getAim() {
        return Aim;
    }

    public void setAim(String Aim) {
        this.Aim = Aim;
    }

    public int getDoctor_ID() {
        return Doctor_ID;
    }

    public void setDoctor_ID(int Doctor_ID) {
        this.Doctor_ID = Doctor_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public boolean isSuccessful() {
        return Successful;
    }

    public void setSuccessful(boolean Successful) {
        this.Successful = Successful;
    }

    public int getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(int Patient_ID) {
        this.Patient_ID = Patient_ID;
    }
    
}