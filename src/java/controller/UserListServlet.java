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
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the current page from the request. Default to 1 if not provided.
            String pageParam = request.getParameter("page");
            int currentPage = pageParam == null ? 1 : Integer.parseInt(pageParam);

            // Define the number of records per page
            int recordsPerPage = 10;

            // Get the total number of users (you will need to implement this method in UserDAO)
            int totalRecords = userDAO.getTotalUsers(); 

            // Calculate the start index for the current page
            int start = (currentPage - 1) * recordsPerPage;

            // Get the list of users for the current page (you will need to implement this in UserDAO)
            List<Users> userList = userDAO.getUsersByPage(start, recordsPerPage);

            // Calculate the total number of pages
            int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

            // Set the list and pagination attributes for the JSP
            request.setAttribute("userList", userList);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("totalPages", totalPages);

            // Forward to the JSP page
            request.getRequestDispatcher("manage_employee.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public static void main(String[] args) {
        try { 
            UserDAO userDAO = new UserDAO();
            List<Users> userList = userDAO.getAllUsers();
            System.out.println("log=" + userList.get(1).getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(UserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}