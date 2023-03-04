<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-List Coffee Shop</title>
</head>
<body>
<header style="background-color: #C4A484; color: white; text-align:center;">Coffee Shop Customers List: </header>
<form method = "post" action="navigationServlet">
<h2>4 Versions of displaying customer list and select one customer to edit/delete</h2>
<table>
<c:forEach items = "${requestScope.allCustomers}" var = "currentitem">
<tr>
<td><input type = "radio" name="id" value="${currentcustomer.id}"> </td>
<td>${currentcustomer.firstName}</td>
<td>${currentcustomer.lastName}</td>
<td>${currentcustomer.phoneNumber}</td>
<td>Customer: ${currentcustomer.firstName} ${currentcustomer.lastName} <br />Phone Number:${currentcustomer.phoneNumber}</td>
<td>Customer Info details version: ${currentcustomer.customerInfoDetails()}</td>
<td>Customer Return details version: ${currentcustomer.returnCustomerDetails()}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToCustomer">
<input type ="submit" value = "delete" name="doThisToCustomer">
<input type ="submit" value = "add" name="doThisToCustomer">
</form>
</body>
</html>