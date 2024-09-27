/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartmentsDAO;
import dao.DoctorDetailsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DoctorDetails;

import java.io.IOException;
import java.util.List;
import model.Departments;

/**
 *
 * @author Haruki
 */
@WebServlet(name = "AddDoctor", urlPatterns = {"/addDoctor"})
public class AddDoctor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Lấy danh sách Departments để hiển thị trong form thêm bác sĩ
        DepartmentsDAO depDao = new DepartmentsDAO();
        List<Departments> listDepartments = depDao.getAllDepartments();
        request.setAttribute("ListDepartments", listDepartments);
        
        // Điều hướng tới trang thêm bác sĩ
        request.getRequestDispatcher("View/addDoctor.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String DB_URL = "Big"; // Thay thế với URL CSDL của bạn
    private static final String USER = "sa"; // Thay thế với tên người dùng CSDL của bạn
    private static final String PASS = "123456"; // Thay thế với mật khẩu CSDL của bạn

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("View/addDoctor.jsp");
       dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String doctorName = request.getParameter("doctorName");
        String departmentId = request.getParameter("department");
        String workHistoryId = request.getParameter("workHistoryID");
        String educationHistoryId = request.getParameter("educationHistoryID");
        String description = request.getParameter("description");
        String portrait = "defaultPortrait.jpg"; 
        String accountStatusStr = request.getParameter("accountStatus");
        boolean accountStatus = "active".equals(accountStatusStr); // Kiểm tra trạng thái tài khoản
        
        // Kiểm tra dữ liệu đầu vào
        if (doctorName == null || doctorName.trim().isEmpty() || 
            departmentId == null || departmentId.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Please fill in all the required fields.");
            processRequest(request, response); // Quay lại form nếu dữ liệu không hợp lệ
            return;
        }

        try {
            // Tạo DAO và thêm bác sĩ mới vào cơ sở dữ liệu
            DoctorDetailsDAO doctorDAO = new DoctorDetailsDAO();
            DoctorDetails newDoctor = new DoctorDetails(0, 0, Integer.parseInt(departmentId), Integer.parseInt(workHistoryId), Integer.parseInt(educationHistoryId), description, portrait,accountStatus);
            doctorDAO.insertDoctor(newDoctor);
            
            // Kiểm tra xem quá trình thêm bác sĩ có thành công không
            if (newDoctor != null) {
                request.setAttribute("successMessage", "Doctor added successfully.");
            } else {
                request.setAttribute("errorMessage", "Failed to add doctor. Please try again.");
            }
        } catch (Exception e) {

            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
        }
        
        processRequest(request, response); // Quay lại form với thông báo thành công/thất bại
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
