<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Registration Form </title>

<link rel="stylesheet" href="CSS/register.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">


</head>
<body>

<div style="margin:20px 400px 20px 400px">
  <form action="register" method="post" style="border:2px solid black" class="form1">

  <b> Name     </b>   : <input type="text" name="userName" placeholder="Enter your name" class="form-control"> <br><br>
  <b> Email    </b>   : <input type="text" name="userEmail" placeholder="Enter your email" class="form-control"> <br><br>
  <b> Password </b>   : <input type="password" name="userPass" placeholder="Enter your password" class="form-control"> <br><br>
  <b> Gender   </b>   : <input type="radio" name="userGender" value="Male"> Male
                        <input type="radio" name="userGender" value="Female"> Female <br><br>
  <b> City     </b>   :  <input type="text" name="userCity" placeholder="Enter your city" class="form-control"> <br><br>
         
         <input type="submit" value="register"  class="btn btn-primary">
           
   

   </form>
</div>

</body>
</html>