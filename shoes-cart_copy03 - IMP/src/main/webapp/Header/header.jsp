<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="CSS/header.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">


<script>
	function cart()
	{
     <%
       if (session == null || session.getAttribute("loggedInUser") == null) {%>
	   window.alert("Please login first");
     <%} 
       else {%>
	window.open("cart.jsp");
    <%}%>
	}

	function Login() {
		window.open("login.jsp");
	}

	function register() {
		window.open("register.jsp");
	}

	function Logout() {

		/* session.invalidate();
		window.open("product.jsp"); */
		window.location.href = "LogOutServlet"; // Call the LogOutServlet to invalidate the session

	}

	function Home() {

		window.open("product.jsp");
	}

	function myOrder() {
		
		<%
	       if (session == null || session.getAttribute("loggedInUser") == null) {%>
		   window.alert("Please login first");
	     <%} 
	       else {%>
		window.open("MyOrder.jsp");
	    <%}%>
	}

	function AboutUs() {
		window.open("AboutUs.jsp");
	}

	function contactUs() {
		window.alert("Address: Belapur CBD Navi Mumbai. Mob No:- 7743890414");
	}
</script>

</head>
<body>

	<!--  ----------------------------Head Content--------------------------------------- -->

	<div class="header">
		<nav class="navbar navbar-info bg-info">
			<!-- Navbar content -->
			<img src="product-images/amazon.jpg" width="100px" height="70px"
				style="margin-left: 4px;">

			<div>

				<!--  Get the user Email from the session -->
				<%--  --%>

				<%
				String userEmail = (String) request.getSession().getAttribute("loggedInUser");
				%>


           <% if (userEmail !=null) { %>
			<h4><%=userEmail%> </h4>	
          <%} %>

				<!-- Rest of your product.jsp page content goes here -->

			</div>

			<div>

				<input type="text" placeholder="search">

				<button style="margin: 4px;">search</button>

				<button style="margin: 4px;" class="btn btn-dark" onclick="cart();">
					cart</button>



				<%
				
				if (session != null && session.getAttribute("loggedInUser") != null) {
				%>
				<input type="submit" value="Logout" class="btn btn-danger"
					style="margin-right: 10px" href="LogOutServlet" onclick="Logout();">
				<%
				} else {
				%>
				<input type="submit" value="Login" class="btn btn-primary"
					style="margin-right: 10px" onclick="Login();"> <input
					type="submit" value="Register" class="btn btn-success"
					style="margin-right: 10px" onclick="register();">
				<%
				}
				%>


			</div>
		</nav>
	</div>

	<nav class="navbar navbar-secondary bg-secondary">

		<button class="btn btn-light" onclick="Home();"
			style="margin-left: 70px">Home</button>

		<button class="btn btn-light" onclick="myOrder();"
			style="margin-left: 120px">My Order</button>

		<button class="btn btn-light" onclick="AboutUs();"
			style="margin-right: 70px">About Us</button>

		<button class="btn btn-light" onclick="contactUs();"
			style="margin-right: 120px">ContactUs</button>

	</nav>

</body>
</html>