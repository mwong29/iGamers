package com.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.beans.Product;
import com.beans.UserLogin;
import com.testdb.DbUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

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
        String selected_game = request.getParameter("game");
        String remove_game = request.getParameter("remove_game");
        
        ArrayList<Product> shopping_cart = (ArrayList) session.getAttribute("shopping_cart");
        
        DbUtil dbUtil = new DbUtil();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            dbUtil.connectToDb();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Initialize shopping_cart if it does not exist in session variable
        if (shopping_cart == null)
        {
            shopping_cart = new ArrayList<>();
        }
        
        if (selected_game != null)
        {
            Product game = null;
            try {
                game = dbUtil.getProductByTitle(selected_game.replaceAll("(\\r|\\n)", ""));
            }
            catch (SQLException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            shopping_cart.add(game);
        }
        
        if (remove_game != null)
        {
            Product game = null;
            try {
                game = dbUtil.getProductByTitle(remove_game.replaceAll("(\\r|\\n)", ""));
            }
            catch (SQLException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (int counter = 0; counter < shopping_cart.size(); counter++)
            {
                if (shopping_cart.get(counter).getTitle().equals(remove_game))
                {
                    shopping_cart.remove(counter);
                    break;
                }
            }          
        }
        
            
        
        UserLogin user = (UserLogin) session.getAttribute("user");
        
        
        session.setAttribute("shopping_cart", shopping_cart);
        request.getRequestDispatcher("shopping_cart.jsp").forward(request, response);
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
