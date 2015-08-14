/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.util.ArrayList;

/**
 *
 * @author Maurice Wong
 */
public final class Confirm
{
    private String html_body;


    double total_payment;
    String email;
    ArrayList<Product> shopping_cart;
    
    public Confirm()
    {
        html_body = "";
        email = "";
        total_payment = 0.0;
        shopping_cart = null;
    }
    
    public Confirm(double total_payment, String email, ArrayList<Product> shopping_cart)
    {
        this.total_payment = total_payment;
        this.email = email;
        this.shopping_cart = shopping_cart;
        this.html_body = generate_html_body();
    }

    public String generate_html_body()
    {
        String html = "";
        
        html += "<table cellspacing='5' cellpadding='5' border='1'>" +
            "<tr>" + 
              "<td align='right'><strong>Name:</strong></td>" + 
              "<td>" + "Name" + "</td>" +
            "</tr>" +
            "<tr>" +
              "<td align='right'><strong>Email:</strong></td>" +
              "<td>" + this.email + "</td>" +
            "</tr>"+
        "</table>"+
        "<table cellspacing='5' cellpadding='5' border='0'>"+
            "<tr>"+
              "<td align='center'><strong>Games</strong></td>"+
              "<td align='center'><strong>Cost</strong></td>"+
            "</tr>";
                System.out.println(total_payment);
        //System.out.println(results.getName());
        for (Product game : this.shopping_cart)
        {
            //this.total_payment += game.getPrice();
            html += ("<tr>");
            html+=("<td>");
            html+=(game.getTitle());
            html+=("</td>");
            html+=("<td>");
            html+=(game.getPrice());
            html+=("</td>");
            html+=("<td>");
            html+=("</td>");
            html+=("</tr>");
        }
        html += "<td align='center'><strong>Other</strong></td>"+
            "</tr>";
                html += "<tr><td></td></tr>"+
            "<tr>"+
                "<td align='center'><strong>TOTAL COST</strong></td>"+
                "<td><strong>"+ this.total_payment +"</strong></td>"+
            "</tr></table>";
                
        return html;
    }
    
    public String getHtml_body()
    {
        return html_body;
    }
}
