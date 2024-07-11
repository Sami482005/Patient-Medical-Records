package Model;

import java.util.Date;

public class Patient {
    private int Patient_SSN;
    private int Patient_ID;
    private Date Date_Of_Birth;
    private String First_Name, Last_Name, email, Phone_Number, Address, Medical_History;
    private char Gender;

    public Patient(int Patient_SSN, int Patient_ID, Date Date_Of_Birth, String First_Name, String Last_Name, String email, String Phone_Number, String Address, String Medical_History, char Gender) {
        this.Patient_SSN = Patient_SSN;
        this.Patient_ID = Patient_ID;
        this.Date_Of_Birth = Date_Of_Birth;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.email = email;
        this.Phone_Number = Phone_Number;
        this.Address = Address;
        this.Medical_History = Medical_History;
        this.Gender = Gender;
    }

    public int getPatient_SSN() {
        return Patient_SSN;
    }

    public void setPatient_SSN(int Patient_SSN) {
        this.Patient_SSN = Patient_SSN;
    }

    public int getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(int Patient_ID) {
        this.Patient_ID = Patient_ID;
    }

    public Date getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(Date Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMedical_History() {
        return Medical_History;
    }

    public void setMedical_History(String Medical_History) {
        this.Medical_History = Medical_History;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

}