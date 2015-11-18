<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ust.edu.model.AddBean" %>
<% AddBean items[] = (AddBean[]) request.getAttribute("items"); %>
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
<title>Home</title>
</head>
<body bgcolor="#DBFFFF">
	<div class="box">
		<hr>
		<h2 class="text-center">How many items would you want to borrow?</h2>
		<hr>
		<center><div class="row">
			<div class="col-md-12">
				<!--style="border-right: 2px solid #555; padding: 20px;">-->
				<form action="updateborrowstable.html" method="post">
					<div class="row">
						<!-- <div class="col-md-5">-->
						</div>
						<div class="col-md-6">
							<input type="hidden" name="lastName" class="form-control" value="${lab.lastName}">
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
						</div>
						<div class="col-md-6">
							<input type="hidden" name="firstName" class="form-control" value="${lab.firstName}">
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
						</div>
						<div class="col-md-6">
							<input type="hidden" name="section" class="form-control" value="${lab.section}">
						</div>
					</div>
					<div class="row">
						
						<!--  <div class="col-md-">-->
							<%
								for(int x=0;x<items.length;x++){ %>
								<div class="row">
									<input type="hidden" name="itemID" value="<%=items[x].getItem()%>"/>
									<div class= "col-md-7"> 
									<label><p><Strong><%=items[x].getItem()%>:</Strong></label>
									</div>
									<div class="col-md-2">
									<input type="text" name="quantity" class="form-control"/>
									</div>
								</div>
							<%}
							%>
							<br><br>
							<center><div class="row">
							<div class="col-md-12">
							</div><input type="submit" value="submit" class="btn btn-primary">
							</form></div><br>
							
							<form action="index.jsp">
							<div class="row">
								<div class="col-md-12">
									<input type="submit" value="BACK TO HOME" class="btn btn-primary">
								</div> 
							</div>
							</form>
							
		</div>

	</div>

</body>
</html>