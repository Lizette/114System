<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Updated</title>
</head>
<body>
<%if(request.getParameter("success").equals("true")){ %>
	<h1><center>SUCCESFUL RECORD UPDATE</center></h1>
	<p>LastName: ${lab.lastName }</p>
	<p>FirstName: ${lab.firstName }</p>
	<p>Section: ${lab.section}</p>
	<p>Item: ${lab.item}</p>
	<%}else{ %>
	<h1>UPDATE FAILED</h1>
	<%} %>
</body>
</html>