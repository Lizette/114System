<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ust.edu.model.AddBean" %>
<% AddBean items[] =(AddBean[]) request.getAttribute("items");%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HOW MANY ITEMS WOULD YOU WANT TO BORROW FOR</h1>
<form action="updateborrowstable.html">
<input type="hidden" name="lastName" value="${lab.lastName}"/>
<input type="hidden" name="firstName" value="${lab.firstName}"/>
<input type="hidden" name="section" value="${lab.section}"/>

<%for(int x=0;x<items.length;x++){ %>
<input type="hidden" name="itemID" value="<%=items[x].getItem()%>"/>
<p><%=items[x].getItem()%><input name="quantity"/></p>
<%}%>

<input type="submit"/>
</form>
</body>
</html>