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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    private UserDAO userDAO=new UserDAO();

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> roles=new ArrayList<>();
        
        try {
            roles = userDAO.getAllRoles();
        } catch (SQLException ex) {
            Logger.getLogger(CreateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("roleList", roles);
        request.getRequestDispatcher("create_employee.jsp").forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");
        int roleId = Integer.parseInt(request.getParameter("roleId"));

        Role role = new Role(roleId, ""); // Bạn có thể tạo thêm logic để lấy RoleName
        Users user = new Users( username, email,  phone, role);

        try {
            userDAO.createUser(user);
            response.sendRedirect("user-list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
