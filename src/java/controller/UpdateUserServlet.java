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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        try {
            Users user = userDAO.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("update_employee.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");
       
       

      
Users u=new Users();
        try {
            u = userDAO.getUserById(userId);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
u.setEmail(email);
u.setPhoneNumber(phone);
u.setUsername(username);
        try {
            userDAO.updateUser(u);
            response.sendRedirect("user-list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}