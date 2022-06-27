/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.parent;

import dal.AccountDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import model.Account;
import model.Kindergartner;
/**
 *
 * @author NQ
 */
public class ChildDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet ChildDetailServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChildDetailServlet at " + request.getContextPath() + "</h1>");
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
            Kindergartner mainchild = (Kindergartner) session.getAttribute("mainchild");
            
            
            Integer mainchildid = (Integer) session.getAttribute("mainchildid");
            try ( PrintWriter out = response.getWriter()) {
                if (acc != null) {
                    StudentDAO d = new StudentDAO();
                    List<Kindergartner> list = d.getKidbyParent(acc.getAccount_id());

                    if(mainchildid == null){
                        Kindergartner firstchild = list.get(0);
                        session.setAttribute("mainchild",firstchild);
                    }else{
                        for(Kindergartner kid : list){
                            if(kid.getKinder_id()==mainchildid){
                                session.setAttribute("mainchild",kid);
                            }
                        }
                    }
                    session.setAttribute("kidlist",list);
                    request.getRequestDispatcher("parent/childdetails.jsp").forward(request, response);
                } else {
                request.setAttribute("error", "Do you want to create an account?");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
