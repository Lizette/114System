<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css" media="screen" />
<style>
 body {
  font-family:  'Arial', sans-serif;
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
.btn {
 background:    #fafafa;
border:        2px solid #73081a;
border-radius: 5px;
box-shadow:    1px 1px 0 0 #444;
color:         #000;
display:       inline-block;
padding:       8px 20px;
font-size:    20px;
text-align:    center;
text-shadow:   none;
}
</style>
<title>Add</title>
</head>
<body bgcolor="#DBFFFF">
	<center><div class="box">
	<script type="text/javascript">
		document.write ('<p>Current time is: <span id="date-time">', new Date().toLocaleString(), '<\/span>.<\/p>')
		if (document.getElementById) onload = function () {
			setInterval ("document.getElementById ('date-time').firstChild.data = new Date().toLocaleString()", 50)
		}
	</script>
	<hr>
	<h2 class="text-center">ChemEng Inventory System</h2>
	<hr>
	<div class="row">
			<form action="addprocess.html" method="post">
				<div class="row">
					<div class="col-md-5"><label>Enter Name of Item:</label></div>
					<div class="col-md-6"><input type="text" name="item" class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-5"><label>Enter Quantity of Item: </label></div>
					<div class="col-md-6"><input type="number" min="1" name="quantity" class="form-control"></div>
				</div>
				<input type="submit" value="Add" class="btn">
			</form>
			<br><br>
			
	
			<hr>
			<center> <form action="index.jsp" method="post">
				<div class="row">
				<div class="col-md-12">
				<input type="submit" value="Click here to go back to Home Page" class="btn">
		 		</div>
				</div>
			</form></center>
		
		
	</div>
	
	</div>

</body>
</html>