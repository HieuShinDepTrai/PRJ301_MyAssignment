/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.instructor.weeklytable;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.User;

/**
 *
 * @author Hiếu Shin FPT
 */
public class AttendanceController extends HttpServlet {

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
            out.println("<title>Servlet AttendanceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceController at " + request.getContextPath() + "</h1>");
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
        if (request.getSession().getAttribute("account") == null) {
            response.getWriter().print("<h1>Access Denied - You are not login</h1>");
            return;
        }

        if ((Boolean) request.getSession().getAttribute("isInstructor") == false) {
            response.getWriter().print("<h1>Access Denied - You are not instructor</h1>");
            return;
        }

        SessionDBContext sessionDBContext = new SessionDBContext();
        Session session = sessionDBContext.getSessions(
                Integer.parseInt(request.getParameter("sid")),
                Integer.parseInt(request.getParameter("cid")));
        request.setAttribute("session", session);
        request.getRequestDispatcher("/views/instructor/weeklytable/attendance.jsp?sid="
                + request.getParameter("sid")
                + "&cid=" + request.getParameter("cid")).forward(request, response);
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
        SessionDBContext sessionDBContext = new SessionDBContext();
        Session session = sessionDBContext.getSessions(Integer.parseInt(request.getParameter("sid")), Integer.parseInt(request.getParameter("cid")));
        String[] users = request.getParameterValues("user");
        String[] status = request.getParameterValues("status");
        ArrayList<Attendance> attendances = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            Attendance attendance = new Attendance();
            attendance.setSessionId(session.getSessionId());
            attendance.setStatus(Boolean.parseBoolean(status[i]));
            User user = new User();
            user.setUserId(Integer.parseInt(users[i]));
            attendance.setUsers(user);
            attendances.add(attendance);

        }
        AttendanceDBContext attendanceDB = new AttendanceDBContext();
        attendanceDB.insertManny(attendances);
        response.sendRedirect(request.getContextPath() + "/report/attendance?sid="
                + request.getParameter("sid")
                + "&cid=" + request.getParameter("cid"));
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
