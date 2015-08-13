<%-- 
    Document   : browse
    Created on : Aug 11, 2015, 11:09:41 AM
    Author     : Maurice Wong
--%>

<%@page import="com.beans.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browsing Games</title>
    </head>
    <body>
        <% 
            String selected_console = (String) session.getAttribute("console");
            out.println(selected_console + " Games:<br /><br />");
            
        %>
        <form method="get" action="/iGamers/Cart">
        <%
            if (selected_console.equals("PS4")) {
        %>
        
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <option value="PS4 Game1">PS4 Game1</option>
                <option value="PS4 Game2">PS4 Game2</option>
                <option value="PS4 Game3">PS4 Game3</option>
                <option value="PS4 Game4">PS4 Game4</option>
            </select>
        <%
            } else if (selected_console.equals("Xbox One")) {
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <option value="Xbox One Game1">Xbox One Game1</option>
                <option value="Xbox One Game2">Xbox One Game2</option>
                <option value="Xbox One Game3">Xbox One Game3</option>
                <option value="Xbox One Game4">Xbox One Game4</option>
            </select>
        <%
            } else if (selected_console.equals("Wii U")) {
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <option value="Wii U Game1">Wii U Game1</option>
                <option value="Wii U Game2">Wii U Game2</option>
                <option value="Wii U Game3">Wii U Game3</option>
                <option value="Wii U Game4">Wii U Game4</option>
            </select>
        <%
            } else if (selected_console.equals("PC")) {
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <option value="PC Game1">PC Game1</option>
                <option value="PC Game2">PC Game2</option>
                <option value="PC Game3">PC Game3</option>
                <option value="PC Game4">PC Game4</option>
            </select>
        <%
            }
        %>
            <br /><br />
            <input type="submit" value="Add To Cart">
        </form>
    </body>
</html>
