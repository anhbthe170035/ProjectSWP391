/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Haruki
 */
public class EducationHistory {
    private int EducationHistoryID;
    private int DoctorID;
    private String Degree;
    private int StartYear;
    private int EndYear;
    private String EducationDetails;

    public EducationHistory() {
    }

    public EducationHistory(int EducationHistoryID, int DoctorID, String Degree, int StartYear, int EndYear, String EducationDetails) {
        this.EducationHistoryID = EducationHistoryID;
        this.DoctorID = DoctorID;
        this.Degree = Degree;
        this.StartYear = StartYear;
        this.EndYear = EndYear;
        this.EducationDetails = EducationDetails;
    }

    public int getEducationHistoryID() {
        return EducationHistoryID;
    }

    public void setEducationHistoryID(int EducationHistoryID) {
        this.EducationHistoryID = EducationHistoryID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }

    public int getStartYear() {
        return StartYear;
    }

    public void setStartYear(int StartYear) {
        this.StartYear = StartYear;
    }

    public int getEndYear() {
        return EndYear;
    }

    public void setEndYear(int EndYear) {
        this.EndYear = EndYear;
    }

    public String getEducationDetails() {
        return EducationDetails;
    }

    public void setEducationDetails(String EducationDetails) {
        this.EducationDetails = EducationDetails;
    }

    @Override
    public String toString() {
        return "EducationHistory{" + "EducationHistoryID=" + EducationHistoryID + ", DoctorID=" + DoctorID + ", Degree=" + Degree + ", StartYear=" + StartYear + ", EndYear=" + EndYear + ", EducationDetails=" + EducationDetails + '}';
    }
    
    
}
