<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<header>
      <h1>Edit Customer</h1>
</header>
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
  <form action = "editCustomerServlet" method="post">
    <input type="hidden" name="id" value="${CustomerToEdit.id}">
    <label>First Name:</label>
    <input type="text" name="firstName" value="${CustomerToEdit.firstName}"><br>
    <label>Last Name:</label>
    <input type="text" name="lastName" value="${CustomerToEdit.lastName}"><br>
    <label>Phone Number:</label>
    <input type="text" name="phoneNumber" value="${CustomerToEdit.phoneNumber}"><br>
    <button type="submit">Save Changes</button>
  </form>
 </div>
 </main>
   <footer>
      <p>&copy; 2023 Coffee Shop</p>
    </footer>
  </body>
  </html>
 