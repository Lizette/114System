<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css" media="screen" />
<style>
 body {
  font-family: 'Arial', sans-serif;
  margin: 20px;
  background-image: url('lab.jpg');
  color: #fff;
  }
  
  label {
  	padding-top: 8px;
  }
  
  input {
  	margin-bottom: 15px;
  }
  
  .box {
  	padding: 30px;
  	background-color: rgba(0,0,0,0.8);
  	margin-top: 5%;
  }
</style>
<title>Passenger Transaction Status</title>
</head>
<body bgcolor="#DBFFFF"><center>
<%
	if (request.getParameter("success").equals("true")) { %>
		<div class="box">
		<hr>
		<h2 class="text-center">Successful Transaction</h2>
		<hr>
		<div class="row">
				<h3>You have added an item </h3>
				<h4> <strong>Item:</strong> ${add.item}</h4>
				<h4><strong>Quantity:</strong> ${add.quantity}</h4>
		</div>	
		
	<% } else { %>
  <h1>Registration Failed</h1>		
<% } %> 
			<hr>
			<form action="index.jsp" method="post">
				<div class="row">
						<input type="submit" value="Click here to go back to form" class="btn btn-primary">
				</div>
			</form>
		</div>
	


</center>
</body>
</html>