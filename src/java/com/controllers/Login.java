/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christopher
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class Login extends HttpServlet {

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
        /*try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String goLogin = request.getParameter("login");
        String account = request.getParameter("account option");
        
        UserLogin user = new UserLogin(username, password);
        
        // if user is not logged in (i.e. username is empty ("")
            // goto login.jsp
        // else
            // goto account.jsp

        // if button clicked is Reset U/P
            // create new user
        // else if button clicked is Go to Shopping Cart
            // goto shopping_cart.jsp
        // else if button clicked is Continue Shopping
            // goto index.jsp
        
        if (goLogin.equals("create")) {
            // Create new user account in DB
            
            // Validate if username already exists
                // if (user.getUsername().equals(//DB CALL//)) { }
            
            
        } else if (goLogin.equals("Submit")) {
            // Validate if user info matches DB values
                // if (user.getUsername().equals(//DB CALL//) && user.getPassword().equals(//DB CALL//)) { user.setIsValidLogin(true) } else { user.setIsValidLogin(false);
            
                    // TEST: isValidUser = true;
                    // TEST: isValidUser = false;
                    Boolean isValidUser = false;
                    
            user.setIsValidLogin(isValidUser);
                                    System.out.println("TEST = " + user.getIsValidLogin());

            // Forward upon incorrect/correct credentials
            if (user.getIsValidLogin() == false) {

                session.setAttribute("user", user);
                response.sendRedirect("login.jsp");
            } else {
                // Successful login
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
