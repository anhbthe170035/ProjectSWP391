/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Haruki
 */
public class WorkHistory {
    private int WorkHistoryID;
    private int DoctorID;
    private String JobTitle;
    private int StartYear;
    private int EndYear;
    private String JobDetails;

    public WorkHistory() {
    }

    public WorkHistory(int WorkHistoryID, int DoctorID, String JobTitle, int StartYear, int EndYear, String JobDetails) {
        this.WorkHistoryID = WorkHistoryID;
        this.DoctorID = DoctorID;
        this.JobTitle = JobTitle;
        this.StartYear = StartYear;
        this.EndYear = EndYear;
        this.JobDetails = JobDetails;
    }

    public int getWorkHistoryID() {
        return WorkHistoryID;
    }

    public void setWorkHistoryID(int WorkHistoryID) {
        this.WorkHistoryID = WorkHistoryID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
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

    public String getJobDetails() {
        return JobDetails;
    }

    public void setJobDetails(String JobDetails) {
        this.JobDetails = JobDetails;
    }

    @Override
    public String toString() {
        return "WorkHistory{" + "WorkHistoryID=" + WorkHistoryID + ", DoctorID=" + DoctorID + ", JobTitle=" + JobTitle + ", StartYear=" + StartYear + ", EndYear=" + EndYear + ", JobDetails=" + JobDetails + '}';
    }
    
    
}
