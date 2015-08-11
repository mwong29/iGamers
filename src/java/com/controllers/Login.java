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
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String goLogin = request.getParameter("login");
        String account = request.getParameter("account");
                        
        UserLogin user = new UserLogin(username, password);
        
        /**
         * From LOGIN.JSP
         */
        
        if (username != null) {
            if (goLogin.equals("Create New") || goLogin.equals("Reset")) {
                // Validate if username already exists
                    // if (user.getUsername().equals(//DB CALL//)) {

                        // TEST: isUserAlreadyExists = false;
                        Boolean isValidCreate = true;
                        user.setIsValidCreate(isValidCreate);
                        // response.sendRedirect("login.jsp");
                    // } else { // Create new user with user.getUsername() and user.getPassword() in DB }
                session.setAttribute("user", user);
                request.getRequestDispatcher("account.jsp").forward(request, response);
            } else if (goLogin.equals("Submit")) {
                // Validate if user info matches DB values
                    // if (user.getUsername().equals(//DB CALL//) && user.getPassword().equals(//DB CALL//)) { user.setIsValidLogin(true) } else { user.setIsValidLogin(false);

                        // TEST: isValidUser = true;
                        // TEST: isValidUser = false;
                        Boolean isValidUser = true;
                        user.setIsValidLogin(isValidUser);

                // Proceed upon incorrect/correct credentials
                if (user.getIsValidLogin() == false) {
                    response.sendRedirect("login.jsp");
                } else {
                    // Successful login
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("account.jsp").forward(request, response);
                }
            }
        } else if (account != null) {
        
        /**
         * From ACCOUNT.JSP
         */

            if (account.equals("Reset Username/Password")) {
                user = (UserLogin) session.getAttribute("user");
                user.setIsAccountCurrent(false);
                session.setAttribute("user", user);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                // DB - create new user in DB
                // DB - remove old user credentials from DB
            } else if (account.equals("Go to Shopping Cart")) {
                request.getRequestDispatcher("shopping_cart.jsp").forward(request, response);
            } else if (account.equals("Continue Shopping")){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
