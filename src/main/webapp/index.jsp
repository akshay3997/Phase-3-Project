<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To SportyShoes</h1>
<form action ="login">

UserID<input type ="text" name="userID"><br><br>
Password<input type ="password" name="password"><br><br>
<input type ="submit" value ="login">
</form>


<form action ="Register">
<h3>please register for new User</h3>
<input type ="submit" value="Register User">
</form>


<form action ="Admin">
<h3>For admin login click on AdminLogin</h3>
<input type = "submit" value="AdminLogin">
</form>

<form action ="AdminReg">
<h3>For admin Register click on AdminRegister</h3>
<input type = "submit" value="AdminRegister">
</form>

</body>
</html>