<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Sporty Shoes</h2>
<%String Admin=(String)session.getAttribute("adminID");%>
Welcome to <%=Admin %>

<form action ="ChangePassword">
<h3>To Change Admin Password Click on Change Password</h3>
<input type ="submit" value="Change Password">
</form>

<form action ="BrowseUser">
<h3>To browse the list of user click on Browse User</h3>
<input type ="submit" value="Browse User">
</form>

<form action ="ManageProduct">
<h3>To Manage the product click on Manage Product</h3>
<input type ="submit" value="ManageProduct"><br><br>

</form>



<form action ="logout">
<input type="submit" value = "logout">
</form>


</body>
</html>