<%-- 
    Document   : header
    Created on : Aug 7, 2015, 1:44:20 AM
    Author     : Christopher
--%>

<html>
    <head>
        <title>iGamers: The only place to buy games</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/iGamers/resources/css/style.css" />
    </head>

    <body>
        <span class="title">
            iGamers | 
            <span class="subtitle">
                Play to win!
            </span>
        </span>
        
        
        <span class="my_account">
            <a href="/iGamers/Account"><img class="my_account_icon" src="resources/images/my_account_icon.png" alt="My Account"></a>
        </span>
        <span class="my_account_title">
            <a href="/iGamers/Account">My Account</a>
        </span>
        
        <br>
        
        <span class="my_shopping_cart">
            <a href="/iGamers/Cart"><img class="shopping_cart" src="resources/images/shopping_cart.png" alt="Shopping Cart"></a>
        </span>
        <span class="my_cart">
            <a href="/iGamers/Cart">My Cart</a>
        </span>
        
        <br>
        <form action="/iGamers/Navigate" method="GET">
            <ul>
                <li><input class="nav-bar" type="submit" name="nav" value="Home" /></li>
                <li><input class="nav-bar" type="submit" name="nav" value="PS4" /></li>
                <li><input class="nav-bar" type="submit" name="nav" value="Xbox One" /></li>
                <li><input class="nav-bar" type="submit" name="nav" value="Wii U" /></li>
                <li><input class="nav-bar" type="submit" name="nav" value="PC" /></li>
                <li><input class="nav-bar" type="submit" name="nav" value="About" /></li>
            </ul>
        </form>
<!--        <ul>
            <li><a href="/iGamers/" class="nav-bar">Home</a></li>
            <li><a href="browse.jsp?console=PlayStation 4" class="nav-bar">PS4</a></li>
            <li><a href="browse.jsp?console=Xbox One" class="nav-bar">Xbox One</a></li>
            <li><a href="browse.jsp?console=Wii U" class="nav-bar">Wii U</a></li>
            <li><a href="browse.jsp?console=PC" class="nav-bar">PC</a></li>
            <li><a href="about.html" class="nav-bar">About</a></li>
        </ul>
-->        <br>