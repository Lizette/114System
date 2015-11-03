<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update </title>
</head>
<body>
<form action="updateitems.html" method="post">
<p> ID: ${param.id}</p>
<p> Item: <input type="text" size="25" name="item" value="${add.lastName}"/></p>
<p> Quantity: <input type="text" size="25" name="quantity" value="${add.quantity}"/></p>
<input type="hidden" name="Id" value ="${param.id}"/>
<input type="submit" value="Update item"/>
</form>
</body>
</html>