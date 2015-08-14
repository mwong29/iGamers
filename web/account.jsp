<%-- 
    Document   : account
    Created on : Aug 8, 2015, 5:04:19 PM
    Author     : Christopher
--%>

<%@page import="com.beans.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.beans.UserLogin"%>



<%@ include file="header.jsp" %>

<%
    UserLogin user = (UserLogin) session.getAttribute("user");
    UserProfile prof = (UserProfile) session.getAttribute("prof");
    
    if (user == null) {
        user = new UserLogin();
    }
    if (prof == null) {
        prof = new UserProfile();
    }
    
    if (user.getIsValidLogin() == false) {
%>
        <div style="color:red;weight:5px"><%= user.getInvalidLoginMessage() %></div>
<%
    }
%>
    
    <h3><%= prof.getFirstName() %>, you have successfully logged in!<br/></h3>
    <br/>
    <h4>- Account Details -</h4>

        <form action="/iGamers/Login" method="POST">
            <table width="350" style="text-align:left;">
                <tr>
                    <td>Username:  <%= user.getUsername() %></td>
                </tr>
                <tr>
                    <td>Password:  <%= user.getPassword() %></td>
                </tr>
                <tr>
                    <td><input type="submit" name="account" value="Reset Username/Password"></td>
                </tr>
                <br />
                <tr>
                    <td>First Name:  <input type="text" name="first name" value="<%= prof.getFirstName() %>" /></td>
                </tr>
                <tr>
                    <td>Last Name:  <input type="text" name="last name" value="<%= prof.getLastName() %>" /></td>
                </tr>
                <tr>
                    <td><u>Billing Address</u></td>
                </tr>
                <tr>
                    <td>Street:  <input type="text" name="bill street" value="<%= prof.getBillingAddress().getStreetAddress() %>" /></td>
                </tr>
                <tr>
                    <td>City:  <input type="text" name="bill city" value="<%= prof.getBillingAddress().getCity() %>" /></td>
                </tr>
                <tr>
                    <td>State:  <input type="text" name="bill state" value="<%= prof.getBillingAddress().getState() %>" /></td>
                </tr>
                <tr>
                    <td>Zip:  <input type="text" name="bill zip" value="<%= prof.getBillingAddress().getZip() %>" /></td>
                </tr>
                <tr>
                    <td><u>Shipping Address</u></td>
                </tr>
                <tr>
                    <td>Street:  <input type="text" name="ship street" value="<%= prof.getShippingAddress().getStreetAddress() %>" /></td>
                </tr>
                <tr>
                    <td>City:  <input type="text" name="ship city" value="<%= prof.getShippingAddress().getCity() %>" /></td>
                </tr>
                <tr>
                    <td>State:  <input type="text" name="ship state" value="<%= prof.getShippingAddress().getState() %>" /></td>
                </tr>
                <tr>
                    <td>Zip:  <input type="text" name="ship zip" value="<%= prof.getShippingAddress().getZip() %>" /></td>
                </tr>
                <tr>
                    <td>Email:  <input type="text" name="email" value="<%= prof.getEmailAddress() %>" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="update" value="Update Account"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="account" value="Go to Shopping Cart"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="account" value="Continue Shopping"></td>
                </tr>
            </table>
        </form>
        <br/>
        <form action="SignOutController" method="GET">
            <input name="sign_out" value="Sign Out" type="submit">
        </form>
    </body>
</html>