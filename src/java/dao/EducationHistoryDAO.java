/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.EducationHistory;

/**
 *
 * @author Haruki
 */
public class EducationHistoryDAO {
      Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<EducationHistory> getAllEducationHistory() {
        List<EducationHistory> list = new ArrayList<>();
        String query = "SELECT * FROM EducationHistory";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new EducationHistory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public EducationHistory getEducationHistoryById(int id) {
        String query = "SELECT * FROM EducationHistory WHERE EducationHistoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new EducationHistory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertEducationHistory(EducationHistory education) {
        String query = "INSERT INTO EducationHistory (EducationHistoryID, DoctorID, Degree, StartYear, EndYear, EducationDetails) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, education.getEducationHistoryID());
            ps.setInt(2, education.getDoctorID());
            ps.setString(3, education.getDegree());
            ps.setInt(4, education.getStartYear());
            ps.setInt(5, education.getEndYear());
            ps.setString(6, education.getEducationDetails());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteEducationHistory(int id) {
        String query = "DELETE FROM EducationHistory WHERE EducationHistoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
