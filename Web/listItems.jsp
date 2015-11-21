<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="recordStudent" type="java.sql.ResultSet" scope="request"/>
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
<title>List of Items</title>
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
<h2 class="text-center">List of Items</h2>
<hr>
	<div class="row">
		<div class="col-md-12">
		<!-- TABLE NG LISTAHAN NG LAMAN NG INVENTORY -->
		<table class="table table-bordered">
			<tr>
				<th align="center">ID</th>
			<th align="center">Equipment</th>
			<th align="center">TotalNum</th>
			<th align="center">Edit</th>
			<th align="center">Delete</th>

			</tr>
		
			<% 
				while(recordStudent.next()) {	
			%>
				<tr>
					<td><%=recordStudent.getInt("id")%></td>
					<td><%=recordStudent.getString("equipments")%></td>
					<td><%=recordStudent.getString("TotalNum")%></td>
					
					<td align="center">
					<!-- KUNG TRIP IUPDATE ANG INFO ABOUT SA INVENTORY -->
					  <a href="maintenanceitems.html?id=<%=recordStudent.getInt("id")%>&action=edit">
					  	<img src="edit.png"/>
					  </a>
					</td>
					<td align="center">
					<!-- KUNG TRIP IDELETE ANG ITEM -->
					  <a href="maintenanceitems.html?id=<%=recordStudent.getInt("id")%>&action=delete">
					  	<img src="delete3.png"/>
					  </a>
					</td>
				</tr>					
	<% } %>
		
		</table>
		</div>
	</div>
	<br>
	
	<form action="index.jsp" method="post">
		<div class="row">
			<div class="col-md-12">
				<input type="submit" value="Click here to go back to form" class="btn btn-primary">
		 	</div>
		</div>
	</form>
	
</div>
	</center>
</body>
</html>