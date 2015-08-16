<%-- 
    Document   : register_new
    Created on : Aug 15, 2015, 6:45:58 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>

        <h1 style="width:400px;text-align:center;">Register to iGamers</h1>
        <br/>
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
                        <td style="text-align:left;padding-left:20px"><input type="text" name="username" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="password" /></td>
                        <td>*SSL/HTTPS Protected</td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="first name" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="last name" /></td>
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
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill street" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill city" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill state" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Zip</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="bill zip" /></td>
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
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship street" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship city" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship state" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Zip</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="ship zip" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div class="border-bottom" style="width:400px;text-align:center;">
                Credit Card Information
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
                        <td>Company</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="cc company" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Number</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="cc number" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="cc name" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Expiration Date</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="cc expiration" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>CVV</td>
                        <td style="text-align:left;padding-left:20px"><input type="text" name="cc cvv" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td style="text-align:left;padding-left:20px"><input type="email" name="email" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <br/>
            <div style="width:400px;text-align:center;">
                <input type="submit" name="register" value="Register">
            </div>
        </form>
    </body>
</html>
