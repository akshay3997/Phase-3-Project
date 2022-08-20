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
<label>Product details</label>
<%List<Product> p=(List<Product>)request.getAttribute("list") ;
if(!p.isEmpty()){
%>
<table border="1">
<tr><th>id</th><th>category</th><th>ProductName</th><th>date</th></tr>

<%for(Product pp:p){ %>

<tr><td><%=pp.getId() %></td><td><%=pp.getCategory()%></td><td><%=pp.getProductName() %></td><td><%=pp.getDate() %></td></tr>

<%}} else{%>
<label>No record found</label>
<%} %>
</table>
</body>
</html>
