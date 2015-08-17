<%-- 
    Document   : account
    Created on : Aug 8, 2015, 5:04:19 PM
    Author     : Christopher
--%>

<%@page import="com.beans.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.beans.UserLogin"%>



<%@ include file="header.jsp" %>

<%
    UserLogin user = (UserLogin) session.getAttribute("user");
    UserProfile prof = (UserProfile) session.getAttribute("prof");
    
    if (user == null) {
        user = new UserLogin();
    }
    if (prof == null) {
        prof = new UserProfile();
    }
    
    if (user.getIsValidLogin() == false) {
%>
        <div style="color:red;weight5px"><%= user.getInvalidLoginMessage() %></div>
<%
    }
%>
    
        <div style="width:400px;text-align:center;">
            <h3><%= prof.getFirstName() %>, you have successfully logged in!<br/></h3>
            <br/>
            <h4>- Account Details -</h4>
        </div>

        <form action="/iGamers/Login" method="POST">
            <div>
                <table width="720px">
                    <colgroup>
                        <col width="200px">
                        <col width="200px">
                        <col width="320px" style="text-align:left;">
                    </colgroup>
                    <tr>
                        <td>Username</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="username" value="<%= user.getUsername() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="password" value="<%= user.getPassword() %>" /></td>
                        <td>*SSL/HTTPS Protected</td>
                    </tr>
                </table>
            </div>
            <br/>
            <div style="width:400px;text-align:center;">
                <input type="submit" name="account" value="Reset Password">
            </div>
            <br />
            <div>
                <table width="720px">
                    <colgroup>
                        <col width="200px">
                        <col width="200px">
                        <col width="320px" style="text-align:left;">
                    </colgroup>
                    <tr>
                        <td>First Name</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="first name" value="<%= prof.getFirstName() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="last name" value="<%= prof.getLastName() %>" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div class="border-bottom" style="width:400px;text-align:center;">
                Billing Address
            </div>
            <br/>
            <div>
                <table width="720px">
                    <colgroup>
                        <col width="200px">
                        <col width="200px">
                        <col width="320px" style="text-align:left;">
                    </colgroup>
                    <tr>
                        <td>Street</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill street" value="<%= prof.getBillingAddress().getStreetAddress() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill city" value="<%= prof.getBillingAddress().getCity() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill state" value="<%= prof.getBillingAddress().getState() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Zip</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill zip" value="<%= prof.getBillingAddress().getZip() %>" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div class="border-bottom" style="width:400px;text-align:center;">
                Shipping Address
            </div>
            <br/>
            <div>
                <table width="720px">
                    <colgroup>
                        <col width="200px">
                        <col width="200px">
                        <col width="320px" style="text-align:left;">
                    </colgroup>
                    <tr>
                        <td>Street</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship street" value="<%= prof.getShippingAddress().getStreetAddress() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship city" value="<%= prof.getShippingAddress().getCity() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship state" value="<%= prof.getShippingAddress().getState() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Zip</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship zip" value="<%= prof.getShippingAddress().getZip() %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="email" value="<%= prof.getEmailAddress() %>" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div style="width:400px;text-align:center;">
                <input type="submit" name="update" value="Update Account">
            </div>
            <br/><br/>
            <div>
                <input type="submit" name="account" value="Go to Shopping Cart">
                <br/>
                <input type="submit" name="account" value="Continue Shopping">
            </div>
        </form>
        <br/>
        <form action="SignOutController" method="GET">
            <input name="sign_out" value="Sign Out" type="submit">
        </form>
    </body>
</html>