/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Address;
import com.beans.CreditCardInfo;
import com.beans.UserLogin;
import com.beans.UserProfile;
import com.testdb.DbUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
        String first = request.getParameter("first name");
        String last = request.getParameter("last name");
        String billStreet = request.getParameter("bill street");
        String billCity = request.getParameter("bill city");
        String billState = request.getParameter("bill state");
        String billZip = request.getParameter("bill zip");
        String shipStreet = request.getParameter("ship street");
        String shipCity = request.getParameter("ship city");
        String shipState = request.getParameter("ship state");
        String shipZip = request.getParameter("ship zip");
        String ccCompany = request.getParameter("cc company");
        String ccNumber = request.getParameter("cc number");
        String ccName = request.getParameter("cc name");
        String ccExpDate = request.getParameter("cc expiration");
        String ccCVV = request.getParameter("cc cvv");
        String email = request.getParameter("email");
        
        String goLogin = request.getParameter("login");
        String account = request.getParameter("account");
        String update = request.getParameter("update");
        String register = request.getParameter("register");
        
        UserLogin user = new UserLogin(username, password);
        UserProfile profile = (UserProfile) session.getAttribute("prof");
        DbUtil dbUtil = new DbUtil();
        /**
         * From LOGIN.JSP
         */
        
        if (username != null && goLogin != null) {
            if (goLogin.equals("Submit")) {
                // Validate if user info matches DB values
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    Boolean isValidLogin = dbUtil.validateLogin(user);
                    user.setIsValidLogin(isValidLogin);
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    profile = dbUtil.selectUserProfileByUserLogin(user);
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                // Proceed upon incorrect/correct credentials
                if (user.getIsValidLogin() == false) {
                    //response.sendRedirect("login.jsp");
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    // Successful login
                    session.setAttribute("user", user);
                    session.setAttribute("prof", profile);
                    request.getRequestDispatcher("account.jsp").forward(request, response);
                }
            } else if (goLogin.equals("Create New")) {
                response.sendRedirect("register_new.jsp");
            }
        } else if (username != null && register != null) {
            if (register.equals("Register")) {
                // Validate if username already exists
                    // if (user.getUsername().equals(//DB CALL//)) {

                int billZipNum = 0;
                int shipZipNum = 0;
                int ccCVVNum = 0;
                if (!billZip.equals("")) {
                    try {
                        billZipNum = Integer.parseInt(billZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                if (!shipZip.equals("")) {
                    try {
                        shipZipNum = Integer.parseInt(shipZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                if (!ccCVV.equals("")) {
                    try {
                        ccCVVNum = Integer.parseInt(ccCVV);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }

                UserLogin newUserLogin = new UserLogin(username, password);
                Address newBilling = new Address(billStreet, billCity, billState, billZipNum);
                Address newShipping = new Address(shipStreet, shipCity, shipState, shipZipNum);
                CreditCardInfo newCC = new CreditCardInfo(ccCompany, ccNumber, ccName, ccExpDate, ccCVVNum);
                UserProfile newUserProfile = new UserProfile(newUserLogin, first, last, newBilling, newShipping, newCC, email);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    Boolean isUserExists = dbUtil.createProfile(newUserProfile);
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                session.setAttribute("user", user);
                session.setAttribute("prof", newUserProfile);
                request.getRequestDispatcher("account.jsp").forward(request, response);
            }
        } else if (account != null) {
        
        /**
         * From ACCOUNT.JSP
         */

            if (account.equals("Reset Password")) {
                user = (UserLogin) session.getAttribute("user");
                profile = (UserProfile) session.getAttribute("prof");
                
                String newPassword = request.getParameter("password");
                
                UserLogin testLogin = user;
                UserProfile testProfile = profile;
                testLogin.setPassword(newPassword);
                testProfile.setUserLogin(testLogin);
                // update DB & check if valid
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    boolean resultUpdateProfile = dbUtil.updateUserLogin(user, testLogin);
                    System.out.println(resultUpdateProfile);
                    if (resultUpdateProfile == true) {
                        user.setPassword(newPassword);
                        profile.setUserLogin(user);
                    }
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                session.setAttribute("user", user);
                session.setAttribute("prof", profile);
                request.getRequestDispatcher("account.jsp").forward(request, response);
                // DB - create new user in DB
                // DB - remove old user credentials from DB
            } else if (account.equals("Go to Shopping Cart")) {
                request.getRequestDispatcher("shopping_cart.jsp").forward(request, response);
            } else if (account.equals("Continue Shopping")){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        } else if (update != null) {
            if (update.equals("Update Account")) {
                user = (UserLogin) session.getAttribute("user");
                profile = (UserProfile) session.getAttribute("prof");
                
                Address billingAddr = new Address();
                Address shippingAddr = new Address();
            
                int billZipNum = 0;
                int shipZipNum = 0;
                
                if (!billZip.equals("")) {
                    try {
                        billZipNum = Integer.parseInt(billZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                if (!shipZip.equals("")) {
                    try {
                        shipZipNum = Integer.parseInt(shipZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                
                profile.setFirstName(first);
                profile.setLastName(last);
                billingAddr.setStreetAddress(billStreet);
                billingAddr.setCity(billCity);
                billingAddr.setState(billState);
                billingAddr.setZip(billZipNum);
                shippingAddr.setStreetAddress(shipStreet);
                shippingAddr.setCity(shipCity);
                shippingAddr.setState(shipState);
                shippingAddr.setZip(shipZipNum);
                profile.setBillingAddress(billingAddr);
                profile.setShippingAddress(shippingAddr);
                
                // update DB
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    Boolean prof = dbUtil.updateProfile(profile);
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                session.setAttribute("user", user);
                session.setAttribute("prof", profile);
                request.getRequestDispatcher("account.jsp").forward(request, response);
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
