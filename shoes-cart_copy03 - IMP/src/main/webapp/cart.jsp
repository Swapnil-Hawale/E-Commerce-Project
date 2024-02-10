<%@ page import="java.sql.*" %>
<%@ page import="com.sg.beans.CartBean" %>
<%@ page import="com.sg.dao.CartDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    
    <script>
    
    function buyNow()
    {
    	//window.alert("Product Buy Successfully")
    }
    
    </script>
    
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<body>

<%@ include file="Header/header.jsp" %> 
<h1>Cart</h1>
<table class="table table-loght" id="">
    <tr>
        <th scope="col">Product Name</th>
        <th scope="col">Price</th>
        <th scope="col">Total Quantity</th>
        <th scope="col">Total Price</th>
        <th scope="col">Cancel</th>
    </tr>

    
   <%
    // Fetch cart items from the database
    int userId = 1; // Replace with your user id or retrieve it from the session
    List<CartBean> cartItems = CartDAO.getCartItems(userId);
    int totalPriceAllProducts = 0;

    for (CartBean cartItem : cartItems) {
        int cartId = cartItem.getCart_id();
        String productName = cartItem.getProduct_name();
        int price = cartItem.getPrice();
        int totalQuantity = cartItem.getTotal_quantity();
        int totalPrice = cartItem.getTotal_price();
        totalPriceAllProducts += totalPrice;
%>

<!-- Your HTML table rows for each cart item -->
<tr>
    <td><%= productName %></td>
    <td><%= price %></td>
    <td><%= totalQuantity %></td>
    <td><%= totalPrice %></td>
    <td>
        <form action="removeFromCart" method="post">
            <input type="hidden" name="cart_id" value="<%= cartId %>">
            <input type="submit" value="Remove" class="btn btn-danger">
        </form>
    </td>
</tr>

<%
    }
%>

</table>
<!-- Total price row -->
<tr>
    <td colspan="3"></td>
    <td><b>Total Products Price:</b></td>
    <td><b><%= totalPriceAllProducts %></b></td>
</tr>

<!-- <form action="addToMyOrder" method="post" class="buyNow">
    <input type="submit" onclick="buyNow()" value="Buy Now" class="btn btn-warning" style="margin-left: 1120px">
</form> -->

<form action="addToMyOrder" method="post" class="buyNow">
    <% if(totalPriceAllProducts == 0) { %>
        <input type="button" value="Buy Now" onclick="alert('Please add products first')" class="btn btn-warning" style="margin-left: 1120px">
    <% } else { %>
        <input type="submit" onclick="alert('Thank You....Your Order Successfully')" value="Buy Now" class="btn btn-warning" style="margin-left: 1120px">
    <% } %>
</form>


</body>
</html>


