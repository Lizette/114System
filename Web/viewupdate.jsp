<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Successful</title>
</head>
<body>
<h1>Item updated</h1>
<p>Item: ${add.item}</p>
<p>Quantity: ${add.quantity}</p>
<p><form action="update.jsp" method="post">
<input type="submit" value="Return"/>
</form>
</body>
</html>