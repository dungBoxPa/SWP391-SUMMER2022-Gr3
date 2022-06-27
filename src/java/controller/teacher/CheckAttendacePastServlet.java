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
public class CheckAttendacePastServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckAttendacePastServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckAttendacePastServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        Account acc = (Account) session.getAttribute("account");
        StudentDAO studao = new StudentDAO();
        Kinder_Class kc = (Kinder_Class) session.getAttribute("kinder_class");
        String action = request.getParameter("action");
        try ( PrintWriter out = response.getWriter()) {
            String date1 = request.getParameter("todayDate");
            String today = java.time.LocalDate.now().toString();
            if (action.equals("checkout")) {
                if (date1.equals(today)) {
                    response.sendRedirect("checkout");
                } else {
                    AttendanceDAO attdao = new AttendanceDAO();
                    List<Attendence> listAtt = attdao.getAllAttendanceOfInputDay(date1).stream()
                            .filter(x -> x.getStatus() != 0)
                            .collect(Collectors.toList());
                    List<Kindergartner> listKinder = listAtt.stream()
                            .map(x -> new StudentDAO()
                            .getKidInfoById(x.getStudent_id()))
                            .collect(Collectors.toList());
                    request.setAttribute("listAtt", listAtt);
                    request.setAttribute("date", date1);
                    request.setAttribute("listKinder", listKinder);
                    request.getRequestDispatcher("teacher/checkout.jsp").forward(request, response);
                }
            } else if (action.equals("checkin")) {
                if (date1.equals(today)) {
                    response.sendRedirect("attendance");
                } else {
                    AttendanceDAO attdao = new AttendanceDAO();
                    List<Attendence> listAtt = attdao.getAllAttendanceOfInputDay(date1);
                    List<Kindergartner> listKinder = new ArrayList<>();
                    for (Attendence attendence : listAtt) {
                        Kindergartner e = studao.getKidInfoById(attendence.getStudent_id());
                        listKinder.add(e);
                    }
                    request.setAttribute("listAtt", listAtt);
                    request.setAttribute("date", date1);
                    request.setAttribute("listKinder", listKinder);
                    request.getRequestDispatcher("teacher/checkin.jsp").forward(request, response);
                }
            }

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
