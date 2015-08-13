<%-- 
    Document   : shopping_cart
    Created on : Aug 6, 2015, 12:27:02 AM
    Author     : Christopher
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="header.jsp" %>
        

<br/><br/><br/>This is the Shopping Cart<br/><br/><br/>
<%
    ArrayList<String> shopping_cart = (ArrayList) session.getAttribute("shopping_cart");
%>

    

        <%
            for (String x : shopping_cart)
            {
                
        %>
                <form action="/iGamers/Cart" method="GET">
                    <% out.println(x);%>
                    <input type="text" hidden="true" name="remove_game" value="<% out.println(x); %>">
                    <input class="nav-bar" type="submit" name="remove" value="Remove" />
                </form>
        <%
            }

        %>
        
        <%
            if (!shopping_cart.isEmpty())
            {  
        %>
                <form action="PayController" method="post">
                    <input type="submit" value="Confirm">
                </form>
        <%
            }
        %>
        
                    
                    
                    
    </body>
</html>
