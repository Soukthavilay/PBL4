<%@page import="withUSB.Examp"%>
<%@page import="model.bean.Connect"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.Clients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String client = (String)request.getSession().getAttribute("client");
	List<Connect> listConnect = (List<Connect>)request.getSession().getAttribute("listConnect");

%>
  <div class = "page List Device">
        <h1>ListDevice</h1>
    </div><br>
    <table id = "table">
        <thead>
            <tr>
                <th data-field="NameDevice" data-filter control="input" data-sortable = "true">Name Device</th>
                <th data-field="NameVendor" data- filter contrl = "select" data-sortable = "true">Name Vendor </th>
                <th data-field="Gate" data-filter control="select" data-sortable = "true">Gate</th>
                <th data-field="Time Start" data-filter control="select" data-sortable = "true"> Time Start </th>
                <th data-field="Time End" data-filter control="select" data-sortable = "true">Time End</th>
            </tr>
        </thead>
        <tbody>
        <%for(Connect conn: listConnect){ %>
        	<tr>
        	<td><%= conn.getIdDevice()%></td>
        	<td><%= conn.getIdDevice()%></td>
        	<td><%= conn.getIdGate()%></td>
        	<td><%= conn.getTimeStart()%></td>
        	<td><%= conn.getTimeEnd()%></td>
        	
        	</tr>
        <%}%>
        </tbody>
    </table>
    <form action = GotoViewDeviceServlet method = post>
    	<input type = 'text' name = 'nameclient', value = 'LAPTOP-6Q6JEO63'>
    	<input type = 'submit' value = 'load' name = "load">
    </form>
    <%

    %>
</body>
</html>