/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Users {
    private int userId;
    private String username;
    private String passwordHash;
    private String email;
    private String phoneNumber;
    private boolean isActive;
    private int pharmacyId;
    private Role role;  // Quan hệ giữa User và Role (Role là một đối tượng)

    // Constructor không tham số
    public Users() {}

    // Constructor có tham số
    public Users(int userId, String username, String passwordHash, String email, String phoneNumber, boolean isActive, int pharmacyId, Role role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.pharmacyId = pharmacyId;
        this.role = role;
    }
    // Constructor có tham số
    public Users(int userId, String username, String passwordHash, String email, String phoneNumber, boolean isActive, Role role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.role = role;
    }
   

    public Users(String username, String email, String phoneNumber,Role role) {
        
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
         this.role = role;
    }

    // Getter và Setter cho userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho passwordHash
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Getter và Setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và Setter cho phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter cho isActive
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Getter và Setter cho pharmacyId
    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    // Getter và Setter cho role
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
