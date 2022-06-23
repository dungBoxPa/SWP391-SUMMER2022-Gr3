/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.teacher;

import dal.AttendanceDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

import java.util.List;

import model.Account;
import model.Attendence;
import model.Kinder_Class;
import model.Kindergartner;

/**
 *
 * @author Windows 10 TIMT
 */
public class checkOutServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet checkOutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkOutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession(true);
        Account acc = (Account) session.getAttribute("account");
        String checkDay = java.time.LocalDate.now().toString();
        List<Attendence> attendance = new AttendanceDAO().getAllAttendanceOfInputDay(checkDay);
        if (acc != null) {
            StudentDAO studao = new StudentDAO();
            List<Kindergartner> list = new ArrayList<>();
            for (Attendence a : attendance) {
                if (a.getStatus() != 0) {
                    Kindergartner k = studao.getKidInfoById(a.getStudent_id());
                    list.add(k);
                }
            }
            if (!list.isEmpty()) {
                request.setAttribute("listStudent", list);
                request.setAttribute("date", java.time.LocalDate.now().toString());
                request.getRequestDispatcher("teacher/checkout.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Your attendance record has not been saved. Please save it!");
                request.getRequestDispatcher("attendance").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Do you want to create an account?");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

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

        HttpSession session = request.getSession(true);
        Kinder_Class kinder_class = (Kinder_Class) session.getAttribute("kinder_class");
        Account teacher = (Account) session.getAttribute("teacher");
        List<Attendence> checkoutkids = new ArrayList<>();
        AttendanceDAO attDAO = new AttendanceDAO();
        String date = java.time.LocalDate.now().toString();
        List<Kindergartner> list = attDAO.getAllCheckInKidsOfADay(kinder_class.getClass_id(), date);
        try ( PrintWriter out = response.getWriter()) {
            for (Kindergartner kindergartner : list) {
                int check = Integer.parseInt(request.getParameter("checkAttendence" + kindergartner.getKinder_id()));
                Attendence attendance = null;
                if (check == 1) {
                    attendance = new Attendence(kindergartner.getKinder_id(), date, 2, teacher.getAccount_id());
                } else if (check == 0) {
                    attendance = new Attendence(kindergartner.getKinder_id(), date, 1, teacher.getAccount_id());
                }
                checkoutkids.add(attendance);
                attDAO.updateAttendanceInfor(attendance);
            }
            session.setAttribute("checkoutkids", checkoutkids);
            response.sendRedirect("checkout");
        }
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
