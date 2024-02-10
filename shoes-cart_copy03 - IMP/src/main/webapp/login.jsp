<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"  href="CSS/login.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">



</head>
<body>

<form action="loginForm" method="post" class="login1">

<b> Email </b>   : <input type="text" name="userEmail" placeholder="Enter your email" class="form-control"> <br><br>
<b> Password </b>: <input type="password" name="userPass" placeholder="Enter your password" class="form-control"> <br> <br> 
<input type="submit" value="Login"  class="btn btn-primary">  <br><br>

<a href="register.jsp"> If not registered click here </a>

</form>

</body>
</html>