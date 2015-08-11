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
        <div style="color:red;weight:5px"><%= user.getInvalidLogin() %></div>
<%
    }
%>
    


        <form action="/iGamers/Login" method="GET">
            <table width="350" style="text-align:left;">
                <tr>
                    <td>Username:  <%= user.getUsername() %></td>
                </tr>
                <tr>
                    <td>Password:  <%= user.getPassword() %>"></td>
                </tr>
                <tr>
                    <td><input type="button" name="account option" value="Reset Username/Password" style="width:50"></td>
                </tr>
                <tr>
                    <td><input type="button" name="account option" value="Go to Shopping Cart" style="width:50"></td>
                </tr>
                <tr>
                    <td><input type="button" name="account option" value="Continue Shopping" style="width:50"></td>
                </tr>
            </table>
        </form>
    </body>
</html>