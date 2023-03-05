<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page to display all Orders in DB with details - all-orders-list.jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- <style type="text/css">
body {font-family: Times New Roman, Times, serif;}
</style> -->
</head>
<body>

<header><h1 style="background-color: #C4A484; color: white; text-align:center;">
Coffee Shop Orders List: </h1></header>
<div>
<form method = "post" action="orderNavigationServlet">

<!--  <input type="hidden" name="orderID" value="${orderToEdit.orderID}">-->
<h2>Please select one order to edit/add drink to or delete. </h2>
<h5>Testing to see which version works - looks best - version 1</h5>
<table>
<c:forEach items="${requestScope.allOrders}" var="currentorder">
<tr>
<!--<td><input type="hidden" name="orderID" value="${currentorder.orderID}"></td>-->
<td><input type="radio" name="orderID" value="${currentorder.orderID}"></td> 

<td>Order#: ${currentorder.orderID}  | Order Date: ${currentorder.date}<br/>
Customer: ${currentorder.firstName} ${currentorder.lastName} <br />
Phone Number:${currentorder.phoneNumber}<br>
Drink(s):
<c:forEach items="${currentorder.drinkList}" var="listVal">
<td>Drink #: ${listVal.drinkID} -- Size: ${listVal.drinkSize} |  Type: ${listVal.drinkType} | Price: $ ${listVal.basePrice}</td>
</c:forEach></tr>
<tr><td><br></td></tr>
</c:forEach>
</table>

<br>
<input type ="submit" value = "editOrder" name="doThisToOrder">
<input type ="submit" value = "deleteOrder" name="doThisToOrder">
<input type ="submit" value = "addToOrder" name="doThisToOrder">
</form>
</div>
<br/>
<br>
<div>
<form method = "post" action="orderNavigationServlet">
<!-- <input type="hidden" name="orderID" value="${orderToEdit.orderID}"> -->
<h2>Please select one order to edit/add drink to or delete. </h2>
<h5>Testing to see which version works - looks best - version 2 using displayOrderDetails</h5>
<table>
<c:forEach items="${requestScope.allOrders}" var="currentorder">
<tr>
<!-- <td><input type="hidden" name="orderID" value="${currentorder.orderID}"></td>-->
<td><input type="radio" name="orderID" value="${currentorder.orderID}"></td> 

<td>${currentorder.displayOrderDetails()}</td>
<tr><td><br></td></tr>
</c:forEach>
</table><br>
<br>
<input type ="submit" value = "editOrder" name="doThisToOrder">
<input type ="submit" value = "deleteOrder" name="doThisToOrder">
<input type ="submit" value = "addToOrder" name="doThisToOrder">

</form>
</div>
<br />
<div>
<nav>
<a href="index.html">Return to main page to start a new order</a><br />
<!-- <a href="viewAllCustomersServlet">View list of all Customers in table</a><br /> -->
<a href="viewAllDrinksServlet">View list of all Drinks in table</a><br />
<a href="viewAllOrdersServlet">Refresh page/View all Orders in table</a>
</nav>
</div>

</body>
</html>