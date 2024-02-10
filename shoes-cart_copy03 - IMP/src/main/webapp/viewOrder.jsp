<%@page import="java.sql.*"%>
<%@page import="com.sg.dao.OrderDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.sg.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>

<h1>Order Details</h1>

<table class="table table-light">
    <tr>
        <th scope="col">Order ID</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Quantity</th>
        <th scope="col">Total Price</th>
    </tr>

     <%
    int orderId = Integer.parseInt(request.getParameter("orderId"));
    List<OrderBean> orderDetails = OrderDAO.getOrderDetails(orderId);

    int totalPriceAllProducts = 0; // Variable to store total price

    for (OrderBean orderItem : orderDetails) {
        String productName = orderItem.getProduct_name();
        int productQuantity = orderItem.getTotal_quantity();
        int totalPrice = orderItem.getTotal_price();

        totalPriceAllProducts += totalPrice;
    %>
    <tr>
        <td><%= orderId %></td>
        <td><%= productName %></td>
        <td><%= productQuantity %></td>
        <td><%= totalPrice %></td>
    </tr>
    <%
    }
    %>
</table>

<tr>
    <td colspan="3"></td>
    <td><b>Total Products Price:</b></td>
    <td><b><%=totalPriceAllProducts%></b></td>
</tr>

  
 <form action="removeFromMyOrder" method="post">
      <input type="hidden" name="order_id" value="<%= orderId %>">
      <input type="submit" value="Cancel Order" class="btn btn-danger" style="margin-left: 1070px">
</form>  <br><br>
                
<form action="generatePDF" method="post">
    <input type="hidden" name="order_id" value="<%=orderId%>"> 
    <input type="submit" value="Print Invoice" class="btn btn-success" style="margin-left: 1070px">
</form>

</body>
</html>
