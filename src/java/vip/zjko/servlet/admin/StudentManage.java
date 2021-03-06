/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.servlet.admin;

import vip.zjko.model.Student;
import vip.zjko.util.DaoFactory;
import vip.zjko.util.Pagination;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentManage", urlPatterns = {"/Admin/StudentManage"})
public class StudentManage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pagination pagination = new Pagination();
        String pageNo = request.getParameter("pageNo");
        String sno = request.getParameter("sno");
        int page = 1;
        if (pageNo != null) {
            page = Integer.parseInt(pageNo);
        }
        pagination.setPageNo(page);
        List<Student> students;
        if (sno != null && !"".equals(sno)) {
            pagination.setUrl("StudentManage?sno=" + sno);
            students = DaoFactory.getStudentDao().getSomeBySno(sno, pagination);
        } else {
            pagination.setUrl("StudentManage?");
            students = DaoFactory.getStudentDao().getAll(pagination);
        }
        request.setAttribute("students", students);
        request.setAttribute("pagination", pagination);

        request.getRequestDispatcher("/admin/student.jsp").forward(request, response);
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
