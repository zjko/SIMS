/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "DisplayGrade", urlPatterns = {"/DisplayGrade"})
public class DisplayGrade extends HttpServlet {

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
        String gid = request.getParameter("gid");
        String name = request.getParameter("name");      
        String year = request.getParameter("year");
//        String 
//><td>${g.id}</td><td>${g.name}</td><td>${g.year}</td><td>${g.major.gname}</td><td>${g.major.director}</td>
        
//        
//        Pagination pagination = new Pagination();
//        int page = 1;
//        if (pageNo != null) {
//            page = Integer.parseInt(pageNo);
//        }
//        pagination.setPageNo(page);
//        pagination.setUrl("DisplayStudent?");
//        //所有专业信息
//        List<Major> majors = DaoFactory.getMajorDao().getAll();
//        List<Grade> grades = null;
//        List<Student> students = null;
//
//        //分页显示班级学生信息
//        if (gid != null) {
//            students = DaoFactory.getStudentDao().getSomeByGid(Integer.parseInt(gid));
//            pagination.setUrl(pagination.getUrl() + "&gid=" + gid);
//            if(mid != null) {
//                grades = DaoFactory.getGradeDao().getSomeByMid(Integer.parseInt(mid));
//                pagination.setUrl(pagination.getUrl() + "&gid=" + gid + "&mid=" + mid);
//            }
//        } else {
//            //显示专业下的班级信息和分页显示所有专业的学生信息
//            if (mid != null) {
//                grades = DaoFactory.getGradeDao().getSomeByMid(Integer.parseInt(mid));
//                students = DaoFactory.getStudentDao().getSomeByMid(Integer.parseInt(mid), pagination);
//                pagination.setUrl(pagination.getUrl() + "&mid=" + mid);
//            }
//        }
//
//        //分页显示所有学生信息
//        if (mid == null && gid == null) {
//            students = DaoFactory.getStudentDao().getAll(pagination);
//        }
//
//        request.setAttribute("majors", majors);
//        request.setAttribute("grades", grades);
//        request.setAttribute("students", students);
//        request.setAttribute("pagination", pagination);
//
//        request.getRequestDispatcher("student.jsp").forward(request, response);
//        
        
        
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
