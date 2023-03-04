<%@ page language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Coffee Order Results</title>
  </head>
  <body>
    <h1>Coffee Order Results</h1>
    <%
      // Retrieve form data from form1
      String form1_first_name = request.getParameter("form1_first_name");
      String form1_last_name = request.getParameter("form1_last_name");
      String form1_phone_number = request.getParameter("form1_phone_number");
      String form1_size = request.getParameter("form1_size");
      String form1_coffee_type = request.getParameter("form1_coffee_type");
      String form1_milk_type = request.getParameter("form1_milk_type");
      
     
     
      
      // Display order details
      out.println("<h2>Customer's Order:</h2>");
      out.println("<p>Name: " + form1_first_name + " " + form1_last_name + "</p>");
      out.println("<p>Size: " + form1_size + "</p>");
      out.println("<p>Coffee type: " + form1_coffee_type + "</p>");
      out.println("<p>Milk type: " + form1_milk_type + "</p>");
      
      
      
      // Display customer name input
      out.println("<h2>Customer:</h2>");
      out.println("<p>First Name: " + form1_first_name);
      out.println("<p>Last Name: " + form1_last_name);
      out.println("<p>Phone Number: " + form1_phone_number);
    %>
  </body>
</html>
