<%@page import="model.bean.DeviceConnectDto"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="model.bean.Device"%>
<%@page import="java.util.Map"%>
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
	List<DeviceConnectDto> detectDevice = (List<DeviceConnectDto>)request.getSession().getAttribute("listDev");
	String nameClient = (String)request.getSession().getAttribute("client");
	if(detectDevice.size()==0){
		response.sendRedirect("GotoFromServer");	
	}
	else{
	
			
%>
<div class = "page List Device">
        <h1><%= nameClient %></h1>
    </div><br>
    <table id = "table">
        <thead>
            <tr>
                <th data-field="NameDevice" data-filter control="input" data-sortable = "true">Name Device</th>
                <th data-field="NameVendor" data- filter contrl = "select" data-sortable = "true">Name Vendor </th>
                <th data-field="TypeDevice" data-filter control="select" data-sortable = "true">Gate</th>
                <th data-field="TypeGate" data-filter control="select" data-sortable = "true"> Time Start </th>
            </tr>
        </thead>
        <tbody>
        <%for(DeviceConnectDto dev: detectDevice){ %>
        	<tr>
        	<td><a href = "GotoViewHistoryDevice?idDevice=<%=dev.getIdDevice()%>$<%=nameClient%>"><%= dev.getNameDevice()%></a></a></td>
        	<td><%= dev.getNameVendor()%></td>
        	<td><%= dev.getTypeDevice()%></td>
        	<td><%= dev.getTypeGate()%></td>
        	
        	</tr>
        <%}%>
        </tbody>
    </table>
<%} %>

</body>
</html>