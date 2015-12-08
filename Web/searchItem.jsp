<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:useBean id="recordItem" type="java.sql.ResultSet" scope="request"/>
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
  a.toggler {
    background: red;
    cursor: pointer;
    border: 2px solid black;
    border-right-width: 15px;
    padding: 0 5px;
    border-radius: 5px;
    text-decoration: none;
    transition: all .5s ease;
}

a.toggler.off {
    background: green;
    border-right-width: 2px;
    border-left-width: 15px;
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
		$(document).ready(function(){
		    $('a.toggler').click(function(){
		        $(this).toggleClass('off');
		    });
		});
	</script>
<hr>

<!-- SEARCH BAR -->
<%
	String query="";
	if(request.getAttribute("query")!=null){
		query=(String) request.getAttribute("query");
	}

%>


<form action="searchitem.html">
	<p>SEARCH<input type="text" name="query" value="<%=query%>"></p>
	<input type="submit" value="submit"/>
</form>


<h2 class="text-center">List of Items</h2>
<hr>
	<div class="row">
		<div class="col-md-12">
		<table  class="table table-bordered">
				<tr>
					<th align="center">ID</th>
					<th align="center">Equipments</th>
					<th align="center">TotalNum</th>
				</tr>
				
					<% 
						while(recordItem.next()) {	
					%>
						<tr><a name="<%=recordItem.getInt("id")%>">
							<td><%=recordItem.getInt("id")%></td>
							<td><%=recordItem.getString("Equipments")%></td>
							<td><%=recordItem.getString("TotalNum")%></td>
							</a>
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

	</center>
</body>
</html>