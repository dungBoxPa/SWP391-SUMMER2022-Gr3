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
import java.util.stream.Collectors;
import model.Account;
import model.Attendence;
import model.Kinder_Class;
import model.Kindergartner;

/**
 *
 * @author Windows 10 TIMT
 */
public class FilterStudentServlet extends HttpServlet {

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
            out.println("<title>Servlet FilterStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterStudentServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        String method = request.getParameter("method");
        Account acc = (Account) session.getAttribute("account");
        Kinder_Class kc = (Kinder_Class) session.getAttribute("kinder_class");
        if (action.equalsIgnoreCase("getall")) {
            if (method.equals("checkin")) {
                response.sendRedirect("attendance");
            } else if (method.equals("checkout")) {
                response.sendRedirect("checkout");
            }
        } else if (action.equalsIgnoreCase("absent")) {
            List<Attendence> listAbsent = new ArrayList<>();
            List<Kindergartner> listStu = new ArrayList<>();
            request.setAttribute("filter", "absent");
            request.setAttribute("date", java.time.LocalDate.now().toString());
            if (method.equals("checkin")) {
                listAbsent = new AttendanceDAO().getAllStatusStudent(0);
                listStu = listAbsent.stream()
                        .map(x -> new StudentDAO().getKidInfoById(x.getStudent_id()))
                        .collect(Collectors.toList());
                request.setAttribute("listStudent", listStu);
                request.getRequestDispatcher("teacher/checkin.jsp").forward(request, response);
            } else if (method.equals("checkout")) {
                listAbsent = new AttendanceDAO().getAllStatusStudent(1);
                listStu = listAbsent.stream()
                        .map(x -> new StudentDAO().getKidInfoById(x.getStudent_id()))
                        .collect(Collectors.toList());
                request.setAttribute("listStudent", listStu);
                request.getRequestDispatcher("teacher/checkout.jsp").forward(request, response);
            }

        } else {

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
