<%-- 
    Document   : payment
    Created on : Aug 13, 2015, 11:36:48 AM
    Author     : Maurice Wong
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
    </head>
    <body>
        <h1>Payment</h1>
        <%
            ArrayList<String> shopping_cart = (ArrayList) session.getAttribute("shopping_cart");
            
            double total_cost = 0.0;
            for (String x : shopping_cart)
            {
                total_cost += 50;
                out.println(x + " - $50");
                out.println("<br/>");
            }
            
            out.println("<br/><strong>Total Cost:</strong> " + total_cost + "<br/><br/>");
        %>
        <br/>
        <form action="ConfirmController" method="post">
            <input type="text" name="total_cost" value="<% out.println(total_cost); %>" hidden="true"><br/>
            <strong>Email:</strong> <input type="text" name="email"> <br/>
            <strong>Credit Card Type:</strong> <br/>
            <input type="radio" name="cctype" value ="MasterCard" checked> Master Card 
            <input type="radio" name="cctype" value ="Visa"> Visa 
            <input type="radio" name="cctype" value ="AmericanExpress"> American Express <br/><br/>
            <strong>Credit Card Number:</strong> <input type="text" name="creditcardnum"> <br/>
            <strong>Credit Card Expiration (mm/yy):</strong> <input type="text" name="creditcardexp"> <br/><br/>
            <input type="submit" value="Submit Payment">
        </form>
    </body>
</html>
