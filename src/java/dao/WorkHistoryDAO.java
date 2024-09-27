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
import model.WorkHistory;
/**
 *
 * @author Haruki
 */
public class WorkHistoryDAO {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public List<WorkHistory> getAllWorkHistory() {
        List<WorkHistory> list = new ArrayList<>();
        String query = "SELECT * FROM WorkHistory";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WorkHistory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public WorkHistory getWorkHistoryById(int id) {
        String query = "SELECT * FROM WorkHistory WHERE WorkHistoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new WorkHistory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertWorkHistory(WorkHistory workHistory) {
        String query = "INSERT INTO WorkHistory (WorkHistoryID, DoctorID, JobTitle, StartYear, EndYear, JobDetails) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, workHistory.getWorkHistoryID());
            ps.setInt(2, workHistory.getDoctorID());
            ps.setString(3, workHistory.getJobTitle());
            ps.setInt(4, workHistory.getStartYear());
            ps.setInt(5, workHistory.getEndYear());
            ps.setString(6, workHistory.getJobDetails());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkHistory(int id) {
        String query = "DELETE FROM WorkHistory WHERE WorkHistoryID = ?";
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
