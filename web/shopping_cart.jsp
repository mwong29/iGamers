<%-- 
    Document   : shopping_cart
    Created on : Aug 6, 2015, 12:27:02 AM
    Author     : Christopher
--%>

<%@page import="com.beans.UserProfile"%>
<%@page import="com.beans.Product"%>
<%@page import="com.testdb.DbUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="header.jsp" %>
        

<h4>
<%
    DbUtil dbUtil = new DbUtil();
    Class.forName("com.mysql.jdbc.Driver");
    dbUtil.connectToDb();
    UserProfile prof = (UserProfile) session.getAttribute("prof");
    ArrayList<Product> shopping_cart = (ArrayList) session.getAttribute("shopping_cart");
    
    if (prof == null || prof.getFirstName().equals("")) {
        out.println("Your Shopping Cart");
    } else {
%>
        <%= prof.getFirstName() %>'s Shopping Cart
<%
    }
%>
</h4>
<%  
    if (shopping_cart == null || shopping_cart.isEmpty()) {
        shopping_cart = new ArrayList<Product>();
        out.println("Your shopping cart is empty!");
        out.println("<br/><br/>Please select any console above to browse our items.");
    }
%>
    

        <%
            for (Product x : shopping_cart)
            {
                
        %>
                <form action="/iGamers/Cart" method="GET">
                    <% out.println(x.getTitle() + " - $" + x.getPrice());%>
                    <input type="text" hidden="true" name="remove_game" value="<% out.println(x.getTitle()); %>">
                    <input class="nav-bar" type="submit" name="remove" value="Remove" />
                </form>
        <%
            }

        %>
        
        <%
            if (!shopping_cart.isEmpty())
            {  
        %>
                <button type="reset" onclick="location.href='payment.jsp'">Buy Now</button>
        <%
            }
        %>
        
                    
                    
                    
    </body>
</html>
