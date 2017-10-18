<%-- 
    Document   : shoppingList
    Created on : Oct 11, 2017, 1:44:41 PM
    Author     : 579957
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        </div>
        <h2>List</h2>
        <div>
            <form action="ShoppingList?action=add" method="POST">
            Add item: <input type="text" name="item"> 
            <input type="submit" value="Add">
            </form>
            
            <form action="ShoppingList?action=delete" method="POST">
            <c:forEach var="item" items="${itemList}">
                <input type="radio" name="items" value="${item}">
                <label>${item}</label><br>
            </c:forEach>
        
            <c:if test="${not empty itemList}">
                <input type="submit" value="Delete">
            </c:if>
            </form>
            
        </div>
    </body>
</html>
