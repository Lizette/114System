<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="rs" type="java.sql.ResultSet" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Listing</h1>
	
	<table border="1" width="100%" cellpadding="3" cellspacing="3">
		<tr>
			<th align="center">ID</th>
			<th align="center">Equipment</th>
			<th align="center">TotalNum</th>
			
		</tr>
		
			<% 
				while(rs.next()) {	
			%>
				<tr>
					<td><%=rs.getInt("id")%></td>
					<td><%=rs.getString("equipments")%></td>
					<td><%=rs.getString("TotalNum")%></td>
					
					<td align="center">
					  <a href="updateForm.html?id=<%=rs.getInt("id")%>&action=edit">
					  	<img src="images/Editor.ico"/>
					  </a>
					</td>
					<td align="center">
					  <a href="updateForm.html?id=<%=rs.getInt("id")%>&action=delete">
					  	<img src="images/busy.ico"/>
					  </a>
					</td>
				</tr>			
	<% } %>
</body>
</html>