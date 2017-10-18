<%-- 
    Document   : register
    Created on : Oct 11, 2017, 1:44:26 PM
    Author     : 579957
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList?action=register" method="POST">
            Username: <input type="text" name="username">
            <input type="submit" value="Register name">
        </form>
        ${message}
    </body>
</html>
