<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="AddDetails">
<h2>Add Product</h2>
<label for="Category">Select Category:</label>
  <select name="Category" id="Category">
    <option value="Rainy">Rainy</option>
    <option value="Summer">Summer</option>
  </select>
  <br><br>
  <label>Enter Product Name</label>
<input type ="text" name="ProductName">
<label for="PurchaseDate">PurchaseDate:</label>
  <input type="date" id="PurchaseDate" name="PurchaseDate">
  <input type="submit">
  </form>
  
  <form action ="ShowProduct">
<h2>Show Product</h2>
<label for="Category">Select Category:</label>
  <select name="Category" id="Category">
    <option value="Rainy">Rainy</option>
    <option value="Summer">Summer</option>
  </select>
  <br><br>
  <label>Enter Product Name</label>
<input type ="text" name="ProductName">
<label for="PurchaseDate">PurchaseDate:</label>
  <input type="date" id="PurchaseDate" name="PurchaseDate">
  <input type="submit">
  </form>
</body>
</html>