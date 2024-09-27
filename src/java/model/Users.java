/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Haruki
 */
public class Users {
    int UserID;
    String UserName;
    String PasswordHash;
    String Email;
    String PhoneNumber;
    boolean isActive;
    int PharmacyID;
    int RoleID;

    public Users() {
    }

    public Users(int UserID, String UserName, String PasswordHash, String Email, String PhoneNumber, boolean isActive, int PharmacyID, int RoleID) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.PasswordHash = PasswordHash;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.isActive = isActive;
        this.PharmacyID = PharmacyID;
        this.RoleID = RoleID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getPharmacyID() {
        return PharmacyID;
    }

    public void setPharmacyID(int PharmacyID) {
        this.PharmacyID = PharmacyID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    @Override
    public String toString() {
        return "Users{" + "UserID=" + UserID + ", UserName=" + UserName + ", PasswordHash=" + PasswordHash + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", isActive=" + isActive + ", PharmacyID=" + PharmacyID + ", RoleID=" + RoleID + '}';
    }

    
    
}
