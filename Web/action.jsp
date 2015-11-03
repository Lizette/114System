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
  background-image: url('mrt.jpg');
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
			<div class="col-md-7" style="border-right: 1px solid #fff" >
				The fare amount to <strong>${lab.desName} station</strong> from North Avenue Station is <strong>${passenger.amountWord} pesos</strong>
				<p>Please remember you have to alight at <strong>${passenger.stopNum}</strong>.</p>
				<p>LIST OF FARE PROFITS</p>
				<p>TOTAL FARE FOR ALL STOP 1: ${passenger.stop1TotalWord} pesos</p>
				<p>TOTAL FARE FOR ALL STOP 2: ${passenger.stop2TotalWord} pesos</p>
				<p>TOTAL FARE FOR ALL STOP 3: ${passenger.stop3TotalWord} pesos</p>
				<p>TOTAL FARE FOR ALL STOP 4: ${passenger.stop4TotalWord} pesos</p>
				<p>TOTAL FARE FOR ALL STOP 5: ${passenger.stop5TotalWord} pesos</p>
				<p>TOTAL FARE FOR ALL STOP 6: ${passenger.stop6TotalWord} pesos</p>

				
			</div>
		
	<% } else { %>
  <h1>Registration Failed</h1>		
<% } %> 
		<div class="col-md-5" style="margin-top: 5%">
			<form action="database.jsp" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="Click here to view all tables" class="btn btn-primary">
				 	</div>
				</div>
			</form>
			<br>
			<br>
			<form action="index.jsp" method="post">
				<div class="row">
					<div class="col-md-12">
						<input type="submit" value="Click here to go back to form" class="btn btn-primary">
					</div>
				</div>
			</form>
		</div>
		</div>
	</div>



</body>
</html>