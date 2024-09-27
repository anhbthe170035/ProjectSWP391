/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Haruki
 */
public class DoctorDetails {
    private int doctorID;
    private int userID;
    private int departmentID;
    private int workHistoryID;
    private int educationHistoryID;
    private String description;
    private String portrait;
    private boolean isActive;

    public DoctorDetails() {
    }

    public DoctorDetails(int doctorID, int userID, int departmentID, int workHistoryID, int educationHistoryID, String description, String portrait, boolean isActive) {
        this.doctorID = doctorID;
        this.userID = userID;
        this.departmentID = departmentID;
        this.workHistoryID = workHistoryID;
        this.educationHistoryID = educationHistoryID;
        this.description = description;
        this.portrait = portrait;
        this.isActive = isActive;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getWorkHistoryID() {
        return workHistoryID;
    }

    public void setWorkHistoryID(int workHistoryID) {
        this.workHistoryID = workHistoryID;
    }

    public int getEducationHistoryID() {
        return educationHistoryID;
    }

    public void setEducationHistoryID(int educationHistoryID) {
        this.educationHistoryID = educationHistoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" + "doctorID=" + doctorID + ", userID=" + userID + ", departmentID=" + departmentID + ", workHistoryID=" + workHistoryID + ", educationHistoryID=" + educationHistoryID + ", description=" + description + ", portrait=" + portrait + ", isActive=" + isActive + '}';
    }



    
}
