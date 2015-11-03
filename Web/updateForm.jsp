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
<title>Update</title>
</head>
<body bgcolor="#DBFFFF"><center>
<div class="box">
<hr>
<h2 class="text-center">Item Updated</h2>
<hr>
	<form action="updateitems.html" method="post">
	<div class="row">
		<div class="col-md-12">
		<p>ID: ${param.id}</p>
		<p> Item: <input type="text" size="25" name="item" value="${add.item}"/></p>
		<p> Quantity: <input type="text" size="25" name="quantity" value="${add.quantity}"/></p>
		<input type="hidden" name="Id" value ="${param.id}"/>
		<input type="submit" value="Update item"/>
		</div>
	</div>
	<br>
	</form>
</div>
	</center>
</body>
</html>