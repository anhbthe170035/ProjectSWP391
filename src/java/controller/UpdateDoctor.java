/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartmentsDAO;
import dao.DoctorDetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;import java.util.List;
import model.Departments;
import model.DoctorDetails;
;
/**
 *
 * @author Haruki
 */
@WebServlet(name = "UpdateDoctor", urlPatterns = {"/updateDoctor"})
public class UpdateDoctor extends HttpServlet {

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
        // Lấy doctorID từ request để xác định bác sĩ cần cập nhật
        String doctorIdStr = request.getParameter("doctorID");
        if (doctorIdStr != null && !doctorIdStr.isEmpty()) {
            int doctorID = Integer.parseInt(doctorIdStr);

            // Lấy thông tin của bác sĩ cần cập nhật từ cơ sở dữ liệu
            DoctorDetailsDAO doctorDAO = new DoctorDetailsDAO();
            DoctorDetails existingDoctor = doctorDAO.getDoctorById(doctorID);

            if (existingDoctor != null) {
                // Lấy danh sách Departments để hiển thị trong form cập nhật bác sĩ
                DepartmentsDAO depDao = new DepartmentsDAO();
                List<Departments> listDepartments = depDao.getAllDepartments();
                request.setAttribute("ListDepartments", listDepartments);

                // Đưa thông tin bác sĩ lên form
                request.setAttribute("doctor", existingDoctor);

                // Điều hướng tới trang cập nhật bác sĩ
                request.getRequestDispatcher("View/UpdateDoctor.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Doctor not found.");
                request.getRequestDispatcher("doctorList").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid doctor ID.");
            request.getRequestDispatcher("doctorList").forward(request, response);
        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        int doctorID = Integer.parseInt(request.getParameter("doctorID"));
        String departmentId = request.getParameter("department");
        String workHistoryId = request.getParameter("workHistoryID");
        String educationHistoryId = request.getParameter("educationHistoryID");
        String description = request.getParameter("description");
        String portrait = "defaultPortrait.jpg"; // Ảnh chân dung có thể mặc định hoặc do người dùng tải lên
        String accountStatusStr = request.getParameter("accountStatus");
        boolean accountStatus = "active".equals(accountStatusStr); // Kiểm tra trạng thái tài khoản

        // Kiểm tra dữ liệu đầu vào
        if (departmentId == null || departmentId.trim().isEmpty() || 
            workHistoryId == null || workHistoryId.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Please fill in all the required fields.");
            processRequest(request, response); // Quay lại form nếu dữ liệu không hợp lệ
            return;
        }

        try {
            // Tạo DAO và cập nhật bác sĩ vào cơ sở dữ liệu
            DoctorDetailsDAO doctorDAO = new DoctorDetailsDAO();
            DoctorDetails updatedDoctor = new DoctorDetails(doctorID, 0, Integer.parseInt(departmentId), Integer.parseInt(workHistoryId), Integer.parseInt(educationHistoryId), description, portrait, accountStatus);
            doctorDAO.updateDoctor(updatedDoctor);
            
            // Kiểm tra xem quá trình cập nhật bác sĩ có thành công không
            request.setAttribute("successMessage", "Doctor updated successfully.");
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
