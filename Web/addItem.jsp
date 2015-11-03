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
<title>Add</title>
</head>
<body bgcolor="#DBFFFF">
	<div class="box">
	<hr>
	<h2 class="text-center">ChemEng Inventory System</h2>
	<hr>
	<div class="row">
			<form action="process.html" method="post">
				<div class="row">
					<div class="col-md-5"><label>Enter Name of Item:</label></div>
					<div class="col-md-6"><input type="text" name="itemName" class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-5"><label>Enter Quantity of Item: </label></div>
					<div class="col-md-6"><input type="text" name="quantity" class="form-control"></div>
				</div>
			</form>
			<br><br>
			<center> <form action="index.jsp" method="post">
				<div class="row">
				<div class="col-md-12">
				<input type="submit" value="Click here to go back to Home Page" class="btn btn-primary">
		 		</div>
				</div>
			</form></center>
		
		
	</div>
	
	</div>

</body>
</html>