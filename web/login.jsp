<%-- 
    Document   : login
    Created on : Aug 6, 2015, 12:16:20 AM
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
    
    if (user.getIsValidCreate() == false) {
%>
        <div style="color:red;weight:5px"><%= user.getUserAlreadyExistsMessage() %></div>
<%
    }
    
%>
    


        <form action="/iGamers/Login" method="POST">
            <table width="350">
                <colgroup>
                    <col span="1" style="width:35%;">
                    <col span="1" style="width:65%;">
                </colgroup>
<%
                if (user.getIsAccountCurrent() == true) {
%>
                <tr>
                    <td style="text-align:right;">Username:  </td>
                    <td><input type="text" name="username" value="<%= user.getUsername() %>"></td>
                </tr>
                <tr>
                    <td style="text-align:right;">Password:  </td>
                    <td><input type="password" name="password" value="<%= user.getPassword() %>"></td>
                </tr>
                <tr style="text-align:left;">
                    <td></td>
                    <td><input type="button" name="login" value="Create New" style="width:50">  <input type="submit" name="login" value="Submit" style="width:50"></td>
                </tr>
<%
                } else {
%>
                <tr>
                    <td style="text-align:right;">New Username:  </td>
                    <td><input type="text" name="username" value=""></td>
                </tr>
                <tr>
                    <td style="text-align:right;">New Password:  </td>
                    <td><input type="password" name="password" value=""></td>
                </tr>
                <tr style="text-align:center;">
                    <td><input type="submit" name="login" value="Reset" style="width:50"></td>
                </tr>
<%
                }
%>                
            </table>
        </form>
    </body>
</html>