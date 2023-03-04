<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-List Coffee Shop</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<header><h1>Coffee Shop Customers List:</h1></header>
	<nav>
      	<!-- <a href="index.html">Home</a> 
      	<a href="index.html">Add New Customer Order</a>
      	<a href="viewAllCustomersServlet">View All Customers</a>-->
     	<a href="index.html">Return to main page to add a new customer and start a new order</a>
		<a href="viewAllCustomersServlet">View All Customers in table</a>
		<a href="viewAllOrdersServlet">View All Orders in table</a>
		<a href="#">View All Orders</a>
		<a href="viewAllDrinksServlet">View All Drinks in table</a>
    </nav>
<main>

<div class="coffee-menu">

<form method = "post" action="navigationServlet">
<table>
<c:forEach items = "${requestScope.allCustomers}" var = "currentcustomer">
<tr>
<td><input type = "radio" name="id" value="${currentcustomer.id}"> </td>
<td>${currentcustomer.firstName}</td>
<td>${currentcustomer.lastName}</td>
<td>${currentcustomer.phoneNumber}</td>
<!-- ??Alternative version of displaying customer info? -->
<td>Customer: ${currentcustomer.firstName} ${currentcustomer.lastName}
<br />Phone Number:${currentcustomer.phoneNumber}</td>

</tr>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToCustomer">
<input type ="submit" value = "delete" name="doThisToCustomer">
<input type ="submit" value = "add" name="doThisToCustomer">
</form>
</div>

</main>

<footer>
	<p>&copy; 2023 Coffee Shop</p>
</footer>

</body>
</html>