<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label>User details</label>
<%List<User> u=(List<User>)request.getAttribute("list") ;
if(!u.isEmpty()){
%>
<table border="1">
<tr><th>id</th><th>userID</th><th>email</th></tr>

<%for(User uu:u){ %>

<tr><td><%=uu.getId() %></td><td><%=uu.getUserID()%></td><td><%=uu.getEmail() %></td></tr>

<%}} else{%>
<label>No record found</label>
<%} %>
</table>
</body>
</html>
