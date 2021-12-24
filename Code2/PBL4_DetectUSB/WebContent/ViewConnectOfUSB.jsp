<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="icon.css">
	<link rel="stylesheet" href="Server.css">
<title>Insert title here</title>
</head>
<body>
<%
	String nameClient = (String)request.getSession().getAttribute("nameClient");
	String nameDevice = (String)request.getSession().getAttribute("nameDevice");
	Map<LocalDateTime,LocalDateTime> mapTime = (Map<LocalDateTime,LocalDateTime>)request.getSession().getAttribute("mapTime");
	
%>
	<div class = "page List Time"'>
		<h1><a href = "GotoViewDeviceServlet?nameclient=<%=nameClient%>"><%= nameClient%></a>/<%=nameDevice%></h1>
	</div>
	<div>
	<table>
		<thead>
		<tr>
          <th data-field="TimeStart" data-filter control="input" data-sortable = "true">Time Start Connect</th>
          <th data-field="TimeEnd" data-filter control="input" data-sortable = "true">Time Finish Connect</th>
		</tr>
		</thead>
		<tbody>
			<%for(Map.Entry<LocalDateTime,LocalDateTime> entry : mapTime.entrySet()){ %>
			 	<tr>
			 	<td><%= entry.getKey()%></td>
			 	<td><%= entry.getValue()%></td>
			 	</tr>
			<% }%>
		</tbody>
	</table>
	</div>
</body>
</html>