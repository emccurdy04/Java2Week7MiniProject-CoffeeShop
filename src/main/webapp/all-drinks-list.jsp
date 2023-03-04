<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page to display all Drinks in DB table with details</title>
<style type="text/css">
body {font-family: Times New Roman, Times, serif;}
</style>
</head>

<body>

<header><h1 style="background-color: #C4A484; color: white; text-align:center;">
Coffee Shop Drinks List: </h1>
</header>
<div>
<c:forEach items="${requestScope.allDrinks}" var="currentdrink">
Drink: ${currentdrink.toString()} <br />
<br>
</c:forEach>
<br />
<br /> 
<a href="index.html">Return to main page to start a new order</a><br />
<a href="viewAllCustomersServlet">View list of all Customers in table</a><br />
<a href="viewAllDrinksServlet">Refresh page/View list of all Drinks in table</a><br />
<a href="viewAllOrdersServlet">View all Orders in table</a>
</div>

</body>
</html>