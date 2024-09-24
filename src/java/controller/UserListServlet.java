package controller;

import dao.UserDAO;
import entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/user-list")
public class UserListServlet extends HttpServlet {
    private  UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> userList = userDAO.getAllUsers();
            System.out.println("log="+userList.get(1).getEmail());
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("manage_employee.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    public static void main(String[] args) {
        try { 
            UserDAO userDAO = new UserDAO();
            List<Users> userList = userDAO.getAllUsers();
            System.out.println("log="+userList.get(1).getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(UserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
