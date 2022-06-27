/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.teacher;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import model.Account;
import model.Feedback;

/**
 *
 * @author Windows 10 TIMT
 */
public class feedbackServlet extends HttpServlet {

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
            out.println("<title>Servlet feedbackServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet feedbackServlet at " + request.getContextPath() + "</h1>");
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
        if (acc != null) {
            Account teacher = (Account) session.getAttribute("teacher");
            try {
                int teacher_id = teacher.getAccount_id();
                PrintWriter out = response.getWriter();
                int kid_id = Integer.parseInt(request.getParameter("kid_id"));
                String fb_content = request.getParameter("fb-content");
                double rating = Double.parseDouble(request.getParameter("rating"));
                String date = java.time.LocalDate.now().toString();
                Feedback fb = new Feedback(kid_id, teacher_id, fb_content, rating, date);
                StudentDAO dao = new StudentDAO();
                dao.insertFBtoDB(fb);
                request.setAttribute("action", "feedback");
                request.setAttribute("kid_id", kid_id);
                response.sendRedirect("studentinfor?action=feedback&kid_id=${"+kid_id+"}");
//            response.sendRedirect(date);
//            out.print(kid_id);
            } catch (IOException | NumberFormatException e) {

            }
        }else{
            request.setAttribute("error", "Do you want to create an account?");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
