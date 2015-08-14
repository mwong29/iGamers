<%-- 
    Document   : browse
    Created on : Aug 11, 2015, 11:09:41 AM
    Author     : Maurice Wong
--%>

<%@page import="com.testdb.DbUtil"%>
<%@page import="java.util.ArrayList"%>
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
            DbUtil dbUtil = new DbUtil();
            Class.forName("com.mysql.jdbc.Driver");
            dbUtil.connectToDb();
            String selected_console = (String) session.getAttribute("console");
            out.println(selected_console + " Games:<br /><br />");
            
        %>
        <form method="get" action="/iGamers/Cart">
        <%
            if (selected_console.equals("PS4")) {
                ArrayList<Product> games = dbUtil.getProductsByCategory("PS4");
        %>
        
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <%
                    for (Product x : games)
                    {
                %>
                        <option value="<% out.println(x.getTitle());  %>"><% out.println(x.getTitle());  %></option>
                        
                <%
                    }
                %>
            </select>
        <%
            } else if (selected_console.equals("Xbox One")) {
                ArrayList<Product> games = dbUtil.getProductsByCategory("XBOX ONE");
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <%
                    for (Product x : games)
                    {
                %>
                        <option value="<% out.println(x.getTitle());  %>"><% out.println(x.getTitle());  %></option>
                        
                <%
                    }
                %>
            </select>
        <%
            } else if (selected_console.equals("Wii U")) {
                ArrayList<Product> games = dbUtil.getProductsByCategory("Wii U");
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <%
                    for (Product x : games)
                    {
                %>
                        <option value="<% out.println(x.getTitle());  %>"><% out.println(x.getTitle());  %></option>
                        
                <%
                    }
                %>
            </select>
        <%
            } else if (selected_console.equals("PC")) {
                ArrayList<Product> games = dbUtil.getProductsByCategory("PC");
        %>
            <select name="game" multiple="multiple" size="3" style="width: 200px;">
                <%
                    for (Product x : games)
                    {
                %>
                        <option value="<% out.println(x.getTitle());  %>"><% out.println(x.getTitle());  %></option>
                        
                <%
                    }
                %>
            </select>
        <%
            }
        %>
            <br /><br />
            <input type="submit" value="Add To Cart">
        </form>
    </body>
</html>
