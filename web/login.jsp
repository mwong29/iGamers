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
            <div>
                <table width="720px">
                    <colgroup>
                        <col span="1" style="width:40%;">
                        <col span="1" style="width:60%;">
                    </colgroup>
<%
        if (user.getIsAccountCurrent() == true) {
%>
                    <tr>
                        <td style="padding-right:20px;">Username</td>
                        <td style="padding-left:20px;"><input type="text" name="username" value="<%= user.getUsername() %>"></td>
                    </tr>
                    <tr>
                        <td style="padding-right:20px">Password</td>
                        <td style="padding-left:20px;"><input type="password" name="password" value="<%= user.getPassword() %>"></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div style="width:720px;text-align:center;">
                <input type="submit" name="login" value="Submit" />
                <br/><br/>OR<br/><br/>
                <input type="submit" name="login" value="Create New" />
            </div>
<%
        } else {
%>
                <tr>
                    <td style="padding-right:20px;">New Username:  </td>
                    <td style="padding-left:20px;"><input type="text" name="username" value=""></td>
                </tr>
                <tr>
                    <td style="padding-right:20px;">New Password:  </td>
                    <td style="padding-left:20px;"><input type="password" name="password" value=""></td>
                </tr>
            </table>
            </div>
            <br/>
            <div style="width:720px;text-align:center;">
                <input type="submit" name="login" value="Reset" style="width:50">
            </div>
<%
        }
%>                
           
        </form>
    </body>
</html>