/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.instructor.auth;

import dal.AccountDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Hiếu Shin FPT
 */
public class LoginController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       request.getRequestDispatcher("views/instructor/auth/login.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccountDBContext db = new AccountDBContext();
        Account account = db.getAccountByEmailPassword(email, password);
        if(account != null)
        {
            request.getSession().setAttribute("account", account);
            request.getSession().setAttribute("isInstructor", db.isInstructor(account.getId()));
            response.sendRedirect(request.getContextPath()+"/home");
        }
        else
        {
            request.setAttribute("message", "Email or password wrong, try again");
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.getRequestDispatcher("views/instructor/auth/login.jsp").forward(request, response);
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
