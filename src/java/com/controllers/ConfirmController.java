/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Confirm;
import com.beans.MailUtilGmail;
import com.beans.PaymentBean;
import com.beans.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maurice Wong
 */
@WebServlet(name = "ConfirmController", urlPatterns =
{
    "/ConfirmController"
})
public class ConfirmController extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.mail.MessagingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException
    {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String url = "/confirm.jsp";
        
        //Verify payment
        String cctype = request.getParameter("cctype");
        String email = request.getParameter("email");
        String creditcardnum = request.getParameter("creditcardnum");
        String creditcardexp = request.getParameter("creditcardexp");
        double total_payment = Double.parseDouble(request.getParameter("total_cost"));
        ArrayList<Product> shopping_cart = (ArrayList) session.getAttribute("shopping_cart");
        
        PaymentBean payment = new PaymentBean(cctype, creditcardnum, creditcardexp, total_payment);
        session.setAttribute("payment", payment);
        if (payment.isIsValid() == false)
        {
            url = "/iGamers/payment.jsp";
            response.sendRedirect(url);
        }
        else
        {
                Confirm confirm = new Confirm(total_payment, email, shopping_cart);
                MailUtilGmail.sendMail(email, "iGamers",
                    "iGamers Payment Confirmed", confirm.getHtml_body(), true);
                
                session.removeAttribute("shopping_cart");
                
                RequestDispatcher dispatcher = 
                    getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (MessagingException ex)
        {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (MessagingException ex)
        {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
