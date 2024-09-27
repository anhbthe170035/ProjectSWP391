/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DoctorDetails;

/**
 *
 * @author Haruki
 */
public class DoctorDetailsDAO {
    
    
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public List<DoctorDetails> getAllDoctors() {
        List<DoctorDetails> list = new ArrayList<>();
        String query = "SELECT * FROM DoctorDetails";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                list.add(new DoctorDetails(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DoctorDetails getDoctorById(int id) {
        String query = "SELECT * FROM DoctorDetails WHERE DoctorID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new DoctorDetails(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getBoolean(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertDoctor(DoctorDetails doctor) {
        String query = "INSERT INTO DoctorDetails (UserID, DepartmentID, WorkHistory, EducationHistory, Description, AccountStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, doctor.getUserID());
            ps.setInt(2, doctor.getDepartmentID());
            ps.setInt(3, doctor.getWorkHistoryID());
            ps.setInt(4, doctor.getEducationHistoryID());
            ps.setString(5, doctor.getDescription());
            ps.setString(6, doctor.getDescription());
            ps.setBoolean(7, doctor.isIsActive());
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
    }

    public void deleteDoctor(int id) {
        String query = "DELETE FROM DoctorDetails WHERE DoctorID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
    }
    public List<DoctorDetails> getDoctorsByDepartment(int departmentId) {
    List<DoctorDetails> doctorList = new ArrayList<>();
    String query = "SELECT * FROM DoctorDetails WHERE DepartmentID = ?";

    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, departmentId);
        rs = ps.executeQuery();

        while (rs.next()) {
            DoctorDetails doctor = new DoctorDetails();
            doctor.setDoctorID(rs.getInt("DoctorID"));
            doctor.setDepartmentID(rs.getInt("DepartmentID"));
            doctor.setEducationHistoryID(rs.getInt("EducationHistoryID"));
            doctor.setWorkHistoryID(rs.getInt("WorkHistoryID"));
            doctor.setUserID(rs.getInt("UserID"));
            doctor.setDescription(rs.getString("Description"));
            doctor.setPortrait(rs.getString("Portrait"));
            doctor.setIsActive(rs.getBoolean("AccountStatus"));
            doctorList.add(doctor);
        }
    } catch (Exception e) {
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
        }
    }

    return doctorList;
}
    public void updateDoctor(DoctorDetails doctor) {
    String query = "UPDATE DoctorDetails SET DepartmentID = ?, WorkHistory = ?, EducationHistory = ?, Description = ?, AccountStatus = ? WHERE DoctorID = ?";
    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ps.setInt(1, doctor.getDepartmentID());
        ps.setInt(2, doctor.getWorkHistoryID());
        ps.setInt(3, doctor.getEducationHistoryID());
        ps.setString(4, doctor.getDescription());
        ps.setBoolean(5, doctor.isIsActive());
        ps.setInt(6, doctor.getDoctorID()); // Thêm ID của bác sĩ để xác định bản ghi cần cập nhật
        ps.executeUpdate();
    } catch (Exception e) {

    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {

        }
    }
}

}
