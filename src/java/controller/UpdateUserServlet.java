package controller;

import dao.UserDAO;
import entity.Role;
import entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            request.getRequestDispatcher("update-user.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
        int pharmacyId = Integer.parseInt(request.getParameter("pharmacyId"));
        int roleId = Integer.parseInt(request.getParameter("roleId"));

        Role role = new Role(roleId, "");
        Users user = new Users(userId, username, password, email, phone, isActive, pharmacyId, role);

        try {
            userDAO.updateUser(user);
            response.sendRedirect("user-list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
