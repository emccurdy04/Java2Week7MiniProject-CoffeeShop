<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page to display all Orders in DB with details - all-orders-list.jsp</title>
<style type="text/css">
body {font-family: Times New Roman, Times, serif;}
</style>
</head>
<body>

<header><h1 style="background-color: #C4A484; color: white; text-align:center;">
Coffee Shop Orders List: </h1></header>
<div>
<form method = "post" action="orderNavigationServlet">
<input type="hidden" name="orderID" value="${orderToEdit.orderID}">
<h2>Please select one order to edit/add drink to or delete. </h2>
<h5>Testing to see which version works - looks best - 3 variations in version 1</h5>
<table>
<c:forEach items="${requestScope.allOrders}" var="currentorder">
<tr>
<!--<td><input type="hidden" name="orderID" value="${currentorder.orderID}"></td>-->
<td><input type="radio" name="orderID" value="${currentorder.orderID}"></td> 

<!-- <td>${currentcustomer.firstName}</td>
<td>${currentcustomer.lastName}</td>
<td>${currentcustomer.phoneNumber}</td> -->

<td>Customer: ${currentorder.customer.firstName} ${currentorder.customer.lastName} <br />
Phone Number:${currentorder.customer.phoneNumber}</td>
<td>Customer Info details version: ${currentorder.currentcustomer.customerInfoDetails()}</td>
<td>Customer Return details version: ${currentorder.currentcustomer.returnCustomerDetails()}</td>

</tr>
</c:forEach>
</table>
<br/>
<h5>Testing to see which version works - looks best - version 2 using displayOrderDetails</h5>
<table>
<c:forEach items="${requestScope.allOrders}" var="currentorder">
<tr>
<td><input type="hidden" name="orderID" value="${currentorder.orderID}"></td>
<!-- <td><input type="radio" name="orderID" value="${currentorder.orderID}"></td> -->

<td>${currentorder.displayOrderDetails()}</td>

</tr>
</c:forEach>
</table>

<input type ="submit" value = "edit" name="doThisToOrder">
<input type ="submit" value = "delete" name="doThisToOrder">
<input type ="submit" value = "add" name="doThisToOrder">

</form>
<br />
<a href="index.html">Return to main page to start a new order</a><br />
<a href="viewAllCustomersServlet">View list of all Customers in table</a><br />
<a href="viewAllDrinksServlet">View list of all Drinks in table</a><br />
<a href="viewAllOrdersServlet">Refresh page/View all Orders in table</a>
</div>

</body>
</html>