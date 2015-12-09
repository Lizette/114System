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
	/*background-image: url('0001.png');*/
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
<script type="text/javascript">
	document.write ('<p>Current time is: <span id="date-time">', new Date().toLocaleString(), '<\/span>.<\/p>')
	if (document.getElementById) onload = function () {
		setInterval ("document.getElementById ('date-time').firstChild.data = new Date().toLocaleString()", 50)
	}
</script>
<hr>
<h2 class="text-center">Item Updated</h2>
<hr>
	<form action="updateitems.html" method="post">
	<div class="row">
		<div class="col-md-12">
		<div class="row">
			<p>ID: ${param.id}</p>
		</div>
		<div class="row">
			<div class="col-md-5"><label>Item:</label></div>
			<div class="col-md-6"><input type="text" size="25" name="item" value="${add.item}" class="form-control"></div>
		</div>
		<div class="row">
			<div class="col-md-5"><label> Quantity:</label></div>
			<div class="col-md-6"><input type="text" size="25" name="quantity" value="${add.quantity}" class="form-control"></div>
		</div>
		<input type="hidden" name="Id" value ="${param.id}" class="btn btn-primary">
		<input type="submit" value="Update item" class="btn btn-primary">

		</div>
	</div>
	<br>
	</form>
</div>
	</center>
</body>
</html>