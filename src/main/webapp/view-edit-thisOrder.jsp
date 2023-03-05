<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeeShop Page to display Selected Order object so user can select/edit order or add a Drink </title>
</head>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- <style type="text/css">
body {font-family: Times New Roman, Times, serif;}
</style> -->

<body>

<header><h1 style="background-color: #C4A484; color: white; text-align:center;">
Coffee Shop: View/Edit/Add Drink to Order Page</h1></header>
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

<h2>View/edit list of drinks in this order</h2>
<${requestScope.orderToEdit}>
<!-- ${requestScope.drinkListToEdit} -->

<!-- <h2>Customer: ${customerToEdit.firstName} ${customerToEdit.lastName} <br />
 Order: ${orderToEdit.orderID} </h2> -->
 
 <h3>Customer: ${orderToEdit.firstName} ${orderToEdit.lastName} <br />
 Order #: ${orderToEdit.orderID} </h3>

<form method="post" action="viewEditThisOrderServlet">
<h3>Please select drink to edit. </h3> <br/>
<input type="hidden" name="orderID" value="${orderToEdit.orderID}">
<input type="radio" name="drinkID" value="${currentdrink.drinkID}">
<!-- 
<c:forEach items="${requestScope.drinkListToEdit}" var="currentdrink"></c:forEach> -->
<c:forEach items="${orderToEdit.drinkList}" var="currentdrink">
Drink #: ${currentdrink.drinkID} <br/>
Drink Size: <select id="coffeeSize" name="coffeeSizeInput">
		<option value="${currentdrink.drinkSize}">${currentdrink.drinkSize}</option>
		<option value="small">small</option>
		<option value="medium">medium</option>
		<option value="large">large</option>
	</select><br />
<br>
Drink Type:<select id="coffeeType" name="coffeeTypeInput">
		<option value="${currentdrink.drinkType}">${currentdrink.drinkType}</option>
		<option value="Cappuccino">Cappuccino</option>
		<option value="Expresso">Expresso</option>
		<option value="Macchiato">Macchiato</option>
	</select><br />
<br/>
</c:forEach>
<input type ="submit" value = "editDrink" name="doThisToOrder">
</form>
<br/>

<form method = "post" action="viewEditThisOrderServlet">

<!-- <h2>Customer: ${customerToEdit.firstName} ${customerToEdit.lastName} <br />
 Order: ${orderToEdit.orderID} </h2>  -->
 <h5>2nd version of view/edit list of drinks in this order</h5>
 <!-- ??If did this version would have to then create & direct to a DrinkNavigationServlet?? -->
<h3>Please select which drink you wish to edit or delete. </h3>
<input type="hidden" name="orderID" value="${orderToEdit.orderID}">

<table>
<c:forEach items="${requestScope.orderToEdit.drinkList}" var="currentdrink">
<tr>

<!-- <td><input type="hidden" name="orderID" value="${currentorder.orderID}"></td> -->
<td><input type="radio" name="drinkID" value="${currentdrink.drinkID}"></td>
<td>Drink #: ${currentdrink.drinkID}-- Size: ${currentdrink.drinkSize} |  Type: ${currentdrink.drinkType} | Price: $ ${currentdrink.basePrice}</td>
</tr>
</c:forEach>
</table>
<br/>
<br/>

<!-- ???Add in section here to edit customer name/number or way to route to Servlet/jsp
for editing/deleting just the customer??? -->
<!-- <input type ="submit" value = "editDrink" name="doThisToOrder"> -->
<input type ="submit" value = "deleteDrinkFromOrder" name="doThisToOrder">
<!-- </form> -->

<br/>
<br/>
<div class="coffee-menu">
<!-- <form method="post" action="addDrinkToOrderServlet" > -->
<!-- <form method="post" action="viewEditThisOrderServlet" > -->
<input type="hidden" name="drinkID" value="${orderToEdit.orderID}">

<h3>Add another drink to current order: </h3>
<br>
  <h2>Coffee Shop Menu</h2>
  <h3>Menu Information</h3>
  <!-- <div>Coffee Description</div>
  Add Coffee to Order -->
  <h4>Coffee Size: Small - $2.99, Medium - $3.99, Large - $4.99</h4>
  <label for="coffeeSize">Enter Coffee Size:</label>
	<select id="coffeeSize" name="coffeeSizeInput" required="required">
		<option >-select size-</option>
		<option value="Small">Small</option>
		<option value="Medium">Medium</option>
		<option value="Large">Large</option>
	</select><br>
	<br>
	<h4>Coffee Options: [1]Cappuccino, [2]Expresso, [3]Latte, [4]Macchiato</h4>
	<label for="coffeeType">Enter Coffee Type:</label>
	<select id="coffeeType" name="coffeeTypeInput" required="required">
		<option >-select type of coffee-</option>
		<option value="Cappuccino">Cappuccino</option>
		<option value="Expresso">Expresso</option>
		<option value="Latte">Latte</option>
		<option value="Macchiato">Caffe Macchiato</option>
	</select><br /> 
	<br/>
	<input type ="submit" value = "addDrinkToOrder" name="doThisToOrder">	
   <!-- ><input type="submit" value="Add to Order"> -->
</div>
<br/>
<br/>
</form>

 
<!--<div>-->
<!--<a href="index.html">Return to main page to start a new order</a><br />-->
<!-- <a href="viewAllCustomersServlet">View list of all Customers in table</a><br /> -->
<!-- <a href="viewAllDrinksServlet">View list of all Drinks in table</a><br /> -->
<!-- <a href="viewEditThisOrderServlet">Refresh page/Review this Order</a>-->
<!-- </div>  -->

</body>
</html>