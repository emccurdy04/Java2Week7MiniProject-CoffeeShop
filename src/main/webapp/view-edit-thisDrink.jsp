<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeeShop Page to display Selected Drink object so user can select/edit this Drink </title>
</head>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- <style type="text/css">
body {font-family: Times New Roman, Times, serif;}
</style> -->

<body>

<header><h1 style="background-color: #C4A484; color: white; text-align:center;">
Coffee Shop: Edit Selected Drink in Order Page</h1></header>
<nav>
      	<!-- <a href="index.html">Home</a> -->
      	<!-- <a href="index.html">Add New Customer Order</a>-->
      	<!-- <a href="viewAllCustomersServlet">View All Customers</a>-->
     	<a href="index.html">Return to main page to add a new customer and start a new order</a>
		<!-- <a href="viewAllCustomersServlet">View All Customers in table</a>-->
		<a href="viewAllOrdersServlet">View All Orders in table</a>
		<!--  <a href="#">View All Orders</a>-->
		<a href="viewAllDrinksServlet">View All Drinks in table</a>
</nav>

<h2>View/edit selected drink in this order</h2>
<${requestScope.orderToEdit}>
<${requestScope.drinkToEdit}>

<!-- <h2>Customer: ${customerToEdit.firstName} ${customerToEdit.lastName} <br />
 Order: ${orderToEdit.orderID} </h2> -->
 
 <h3>Customer: ${orderToEdit.firstName} ${orderToEdit.lastName} <br />
 Order #: ${orderToEdit.orderID} </h3>

<form method="post" action="viewEditThisDrinkServlet">
<h3>Please make changes to drink. </h3>
<input ${requestScope.orderToEdit} type="hidden" name="orderID" value="${orderToEdit.orderID}">
<input type="hidden" name="drinkID" value="${drinkToEdit.drinkID}">
<!-- 
<c:forEach items="${requestScope.drinkListToEdit}" var="currentdrink"></c:forEach>-->
<!-- <c:forEach items="${requestScope.orderToEdit.drinkList}" var="currentdrink"> </c:forEach> 
<input type="radio" name="drinkID" value="${currentdrink.drinkID}"> -->
Drink #: ${drinkToEdit.drinkID} <br/>
Drink Size: <select id="coffeeSize" name="coffeeSizeInput">
		<option value="${drinkToEdit.drinkSize}">${drinkToEdit.drinkSize}</option>
		<option value="small">small</option>
		<option value="medium">medium</option>
		<option value="large">large</option>
	</select><br />
<br>
Drink Type:<select id="coffeeType" name="coffeeTypeInput">
		<option value="${drinkToEdit.drinkType}">${drinkToEdit.drinkType}</option>
		<option value="Cappuccino">Cappuccino</option>
		<option value="Expresso">Expresso</option>
		<option value="Macchiato">Macchiato</option>
	</select><br />
<br/>

<input type ="submit" value = "editDrink" name="doThisToDrink">
</form>
<br/>

</body>
</html>