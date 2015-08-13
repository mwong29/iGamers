/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Product;
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
@WebServlet(name = "Navigate", urlPatterns = {"/Navigate"})
public class Navigate extends HttpServlet {

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

        String nav = request.getParameter("nav");
        System.out.println("nav = " + nav);
        UserLogin user = (UserLogin) session.getAttribute("user");   
        Product prod = new Product();
        
        /**
         * From INDEX.JSP
         */
        
        if (nav.equals("Home")) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else if (nav.equals("PS4")) {
            prod.setCategory(nav);
            System.out.println("PROD.GET = " + prod.getCategory());
            session.setAttribute("console", prod.getCategory());
            request.getRequestDispatcher("/browse.jsp").forward(request, response);
        } else if (nav.equals("Xbox One")) {
            prod.setCategory(nav);
            session.setAttribute("console", prod.getCategory());
            request.getRequestDispatcher("/browse.jsp").forward(request, response);
        } else if (nav.equals("Wii U")) {
            prod.setCategory(nav);
            session.setAttribute("console", prod.getCategory());
            request.getRequestDispatcher("/browse.jsp").forward(request, response);
        } else if (nav.equals("PC")) {
            prod.setCategory(nav);
            session.setAttribute("console", prod.getCategory());
            request.getRequestDispatcher("/browse.jsp").forward(request, response);
        } else if (nav.equals("About")) {
            request.getRequestDispatcher("/about.html").forward(request, response);
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
