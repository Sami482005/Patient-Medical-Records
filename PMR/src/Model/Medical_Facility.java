package Model;

public class Medical_Facility {
    private int Medical_Facility_ID;
    private String Facility_Name, Facility_Location;

    public Medical_Facility(){};
    public Medical_Facility(int Medical_Facility_ID, String Facility_Name, String Facility_Location) {
        this.Medical_Facility_ID = Medical_Facility_ID;
        this.Facility_Name = Facility_Name;
        this.Facility_Location = Facility_Location;
    }

    public int getMedical_Facility_ID() {
        return Medical_Facility_ID;
    }

    public void setMedical_Facility_ID(int Medical_Facility_ID) {
        this.Medical_Facility_ID = Medical_Facility_ID;
    }

    public String getFacility_Name() {
        return Facility_Name;
    }

    public void setFacility_Name(String Facility_Name) {
        this.Facility_Name = Facility_Name;
    }

    public String getFacility_Location() {
        return Facility_Location;
    }

    public void setFacility_Location(String Facility_Location) {
        this.Facility_Location = Facility_Location;
    }
    
    @Override 
    public String toString(){
        String s = getMedical_Facility_ID() + "-" + getFacility_Name() + "-" + getFacility_Location();
        return s;
    }
}