<%-- 
    Document   : browse
    Created on : Aug 11, 2015, 11:09:41 AM
    Author     : Maurice Wong
--%>

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
            String selected_console = request.getParameter("console");
            out.println(selected_console);
            
        %>
        <form method="get" action="browse.jsp">
            <select name="console">
                <option value="playstation4">PlayStation 4</option>
                <option value="xboxone">Xbox One</option>
                <option value="wiiu">Wii U</option>
                <option value="pc">PC</option>
            </select>
            <input type="submit" value="Go">
        </form>
    </body>
</html>
