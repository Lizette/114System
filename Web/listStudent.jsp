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
  font-family: Courier New;
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
.srch{
background:    #fff;
border:        2px solid #73081a;
border-radius: 5px;
color:         #000;
display:       inline-block;
padding:       8px 20px;
font-size:    15px;
text-align:    center;
text-shadow:   none;
}
</style>
<title>List of Students</title>
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
	if(request.getParameter("query")!=null){
		query=(String) request.getParameter("query");
	}

%>


<form action="searchstudent.html">
	<b>SEARCH</b> <input type="text" name="query" value="<%=query%>">
	<input type="submit" value="Search" class="srch"/>
</form>


<h2 class="text-center">List of Students</h2>
<hr>
	<div class="row">
		<div class="col-md-12">
		<table  class="table table-bordered">
				<tr>
					<th align="center">ID</th>
					<th align="center">Last Name</th>
					<th align="center">First Name</th>
					<th align="center">Section</th>
					<th align="center">Items</th>
					<th align="center">Quantity</th>
					<th align="center">Date Borrowed</th>
					<th align="center">Date Returned</th>
					<th align="center">Returned?</th>
				</tr>
				
					<% 
						while(recordStudent.next()) {	
					%>
						<tr><a name="<%=recordStudent.getInt("id")%>">
							<td><%=recordStudent.getInt("id")%></td>
							<td><%=recordStudent.getString("LastName")%></td>
							<td><%=recordStudent.getString("FirstName")%></td>
							<td><%=recordStudent.getString("Section")%></td>
							<td><%=recordStudent.getString("itemborrowed")%></td>
							<td><%=recordStudent.getInt("quantity")%></td>
							<td><%=recordStudent.getTimestamp("timein")%></td>
							<td><%=recordStudent.getTimestamp("timeout")%></td></a>
							<td>
							<%if(recordStudent.getString("returned").equals("FALSE")){%>
							<a href="returnitem.html?id=<%=recordStudent.getInt("id")%>&status=<%=recordStudent.getString("returned")%>&query=<%=query%>" class="toggler"><font color="white">NO</font></a>
							<%} else{%>
							<a href="returnitem.html?id=<%=recordStudent.getInt("id")%>&status=<%=recordStudent.getString("returned")%>&query=<%=query%>" class="toggler off"><font color="white">YES</font></a>
							<%} %>
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
				<input type="submit" value="Click here to go back to form" class="btn">
		 	</div>
		</div>
	</form>

	</center>
</body>
</html>