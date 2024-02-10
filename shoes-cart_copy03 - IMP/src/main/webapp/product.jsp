<%@page import="java.sql.*"%> 
<%@ page import="com.sg.dao.DBCon" %>
<%@ page import="com.sg.dao.ProductDAO" %>
<%@ page import="com.sg.beans.ProductBean" %>
<%@ page import="com.sg.dao.UserDAO" %>
<%@ page import="java.util.*" %>
<html>
<head>
<script>
	
	function addToCart() {
	    <% HttpSession ses = request.getSession(false);
	       if (session == null || session.getAttribute("loggedInUser") == null) { %>
	        window.alert("Please login first");
	    <% } else { %>
	        window.alert("Product added successfully");
	      
	    <% } %>
	}
	
	
	function buyNow() {
		window.alert("Product Buy Successfully");
	}
	
</script>

<link rel="stylesheet" href="CSS/product.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

</head>

<body>

   <%@ include file="Header/header.jsp" %> 


	<!--  ----------------------Products Content---------------------------- -->
	<div class="container">
		<!-- <div class="card-header my-3">All Products</div> -->

		<div class="row">

			<%
			try {
					ProductDAO pDAO = new ProductDAO();
					List<ProductBean> products = new ArrayList<>();
					products = pDAO.getProducts();
					
					for(ProductBean p : products){
			%>

			<div class="col-md-3"  style="margin-top: 40px;" >
				<div class="card w-100"  id="imgs" id="imgs">

					<img src="product-images/<%=p.getProductImage()%>.jpg"
						class="card-img-top"  alt="...">

					<h6 class="imageName">
						<%=p.getProductImage()%>
					</h6>

					<!------------------------------------ Update Product Page--------------------------->
					<div class="name">

						<h5 >
							<%=p.getProductName()%>
						</h5>

						<p >
							Price:
							<%=p.getProductPrice()%>
						</p>

		<form action="addToCart" method="post">
      
		  <input type="hidden" name="product_name" value=" <%=p.getProductName()%>">
		  <input type="hidden" name="price" value="<%=p.getProductPrice()%>"> 
		  <input type="hidden" name="total_quantity" value="1">
		  <input type="hidden" name="total_price" value="<%=p.getProductPrice()%>">
		  
	   <div style="display: flex; justify-content: space-between; align-items: center;">
       <input type="submit" style="margin-left: 14px" value="Add to Cart" class="btn btn-primary" onclick="addToCart();">
            
         </form>
      
        </div>
       
					</div>

					<!-------------------------------  Update End ---------------------------------->

				</div>
			</div>


			<%
			}

			} catch (Exception e) {

			}
			%>

		</div>

	</div>

	<hr style="color: black;">

	<a href="FOOTER/Terms&Conditions.jsp" style="margin-left: 5px;">
		Terms & condition </a> |
	<a href="FOOTER/YourAccount.jsp" style="margin-left: 5px;"> Your
		Account</a> |
	<a href="FOOTER/Copyrights.jsp" style="margin-left: 5px;">
		Copyright, authors' rights and database rights </a> |

	<b> Address <b>: Belapur CBD Navi Mumbai Pin code:- 413208 <br>
			<br>
</body>
</html>