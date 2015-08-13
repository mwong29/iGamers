<%-- 
    Document   : account
    Created on : Aug 8, 2015, 5:04:19 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.beans.UserLogin"%>



<%@ include file="header.jsp" %>

<%
    UserLogin user = (UserLogin) session.getAttribute("user");
    
    if (user == null) {
        user = new UserLogin();
    }
    
    if (user.getIsValidLogin() == false) {
%>
        <div style="color:red;weight:5px"><%= user.getInvalidLoginMessage() %></div>
<%
    }
%>
    


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