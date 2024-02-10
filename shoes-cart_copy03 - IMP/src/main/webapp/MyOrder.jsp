<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sg.dao.OrderDAO"%>
<%@page import="com.sg.beans.OrderBean"%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Order</title>

<script>

function openOrder(orderId)
{
	   window.location.href = "viewOrder.jsp?orderId=" + orderId;
}

</script>


</head>

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">

<body>

<%--  <jsp:include page="Header/header.jsp" /> --%>
  <%@ include file="Header/header.jsp" %> 
 
    <h1>My Order</h1>
    <table class="table table-loght">
        <tr>
            <th scop="col">Order ID</th>
            <th scop="col">Product Quantity</th>
            <th scop="col">Total Price</th>
            <!--  <th scop="col">Cancel</th> -->
              <th scop="col">View Order</th>
            
        </tr>

        <%-- Other imports and HTML structure remain the same --%>

<%
    List<OrderBean> orders = OrderDAO.getOrders();
%>

<%-- Fetch orders items from the Java class --%>
<%
for (OrderBean order : orders) {
    int orderId = order.getOrder_id();
    int productQuantity = order.getTotal_quantity();
    int totalPrice = order.getTotal_price();
%>
<tr>
    <td><%=orderId%></td>
    <td><%=productQuantity%></td>
    <td><%=totalPrice%></td>
    <td>
        <input type="submit" onclick="openOrder(<%=orderId%>)" value="Open Order" class="btn btn-danger">
    </td>
</tr>
<%
}
%>

    </table>
</body>
</html>


