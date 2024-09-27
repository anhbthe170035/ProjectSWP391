package dao;

import entity.Users;
import entity.Role;
import context.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        DBContext dbContext = new DBContext();
        connection = dbContext.getConnection();
    }

    // Phương thức để thêm user vào database
    public void createUser(Users user) throws SQLException {
        String query = "INSERT INTO Users (Username, Email, PhoneNumber, RoleID) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPhoneNumber());
        stmt.setInt(4, user.getRole().getRoleId());
        stmt.executeUpdate();
    }

    // Phương thức để lấy danh sách tất cả người dùng
    public List<Users> getAllUsers() throws SQLException {
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM Users JOIN Roles ON Users.RoleID = Roles.RoleID";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Role role = new Role(rs.getInt("RoleID"), rs.getString("RoleName"));
            Users user = new Users(rs.getInt("UserID"), rs.getString("Username"), rs.getString("PasswordHash"), rs.getString("Email"),
                    rs.getString("PhoneNumber"), rs.getBoolean("IsActive"), rs.getInt("PharmacyID"), role);
            users.add(user);
        }

        return users;
    }
      // Phương thức để lấy danh sách tất cả người dùng
    public List<Role> getAllRoles() throws SQLException {
        List<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM Roles";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Role role = new Role(rs.getInt("RoleID"), rs.getString("RoleName"));
            
            roles.add(role);
        }

        return roles;
    }
  

    // Phương thức để lấy user theo ID
    public Users getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM Users JOIN Roles ON Users.RoleID = Roles.RoleID WHERE UserID = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Role role = new Role(rs.getInt("RoleID"), rs.getString("RoleName"));
            return new Users(rs.getInt("UserID"), rs.getString("Username"), rs.getString("PasswordHash"), rs.getString("Email"),
                    rs.getString("PhoneNumber"), rs.getBoolean("IsActive"), rs.getInt("PharmacyID"), role);
        }
        return null;
    }

    // Phương thức để cập nhật thông tin user
    public void updateUser(Users user) throws SQLException {
        String query = "UPDATE Users SET Username = ?, Email = ?, PhoneNumber = ? WHERE UserID = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPhoneNumber());
        stmt.setInt(4, user.getUserId());
        stmt.executeUpdate();
    }

    // Phương thức để xóa user
    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM Users WHERE UserID = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        stmt.executeUpdate();
    }
}
