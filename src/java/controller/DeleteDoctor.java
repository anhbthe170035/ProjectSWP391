/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DoctorDetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;;

/**
 *
 * @author Haruki
 */
@WebServlet(name = "DeleteDoctor", urlPatterns = {"/deleteDoctor"})
public class DeleteDoctor extends HttpServlet {

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
         // Lấy doctorID từ request để xác định bác sĩ cần xóa
        String doctorIdStr = request.getParameter("doctorID");
        if (doctorIdStr != null && !doctorIdStr.isEmpty()) {
            int doctorID = Integer.parseInt(doctorIdStr);

            try {
                // Tạo DAO và thực hiện việc xóa bác sĩ khỏi cơ sở dữ liệu
                DoctorDetailsDAO doctorDAO = new DoctorDetailsDAO();
                doctorDAO.deleteDoctor(doctorID);  // Gọi phương thức deleteDoctor trong DAO

                // Nếu xóa thành công, chuyển hướng về danh sách bác sĩ với thông báo thành công
                request.setAttribute("successMessage", "Doctor deleted successfully.");
                request.getRequestDispatcher("View/doctorList.jsp").forward(request, response);
            } catch (Exception e) {
                // Xử lý ngoại lệ nếu có lỗi trong quá trình xóa
                request.setAttribute("errorMessage", "An error occurred while deleting the doctor: " + e.getMessage());
                request.getRequestDispatcher("View/doctorList.jsp").forward(request, response);
            }
        } else {
            // Nếu không tìm thấy doctorID trong request, trả về thông báo lỗi
            request.setAttribute("errorMessage", "Invalid doctor ID.");
            request.getRequestDispatcher("View/doctorList.jsp").forward(request, response);
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
        processRequest(request, response);
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
