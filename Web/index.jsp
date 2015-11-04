<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css"
	media="screen" />
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
	background-color: rgba(0, 0, 0, 0.8);
	margin-top: 5%;
}
</style>
<title>Tables</title>
</head>
<body bgcolor="#DBFFFF">
	<center>
		<div class="box">
			<hr>

			<h1 class="text-center">
				<strong>Laboratory:</strong>
			</h1>
			<h1 class="text-center">Tools & Equipment Inventory</h1>
			<hr>
			<form action="addItem.jsp" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="Add Equipment" class="btn btn-primary">
					</div>
				</div>
			</form>
			<br>

			<form action="listItems.html" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="View all List" class="btn btn-primary">
					</div>
				</div>
			</form>
			<br>

			<form action="borrowform.html" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="Borrow Form" class="btn btn-primary">
					</div>
				</div>
			</form>
			<br>
			<form action="updateForm.jsp" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="Update" class="btn btn-primary">
					</div>
				</div>
			</form>
		</div>
	</center>

</body>
</html>