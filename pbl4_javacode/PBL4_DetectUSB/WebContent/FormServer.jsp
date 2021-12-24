<%@page import="model.bean.Account"%>
<%@page import="model.bean.Clients"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF8">
  <link rel="stylesheet" href="icon.css">
  <link rel="stylesheet" href="Server.css">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
<% 	Account account = (Account)request.getSession().getAttribute("account");
	List<Clients> listClient = (List<Clients>)request.getSession().getAttribute("listClient");
	if(account == null){
		response.sendRedirect("GoLoginServlet");	
	}
	else{
%>
<div class="grid">
    <header class="page-header content">
      <img src="img/newlogo2.png" alt="">
      <div align="center">
      <img src="img/welcome.png" alt="">
    </div>
      <div align="right" style="padding-right: 13%;">
      <h3>Admin</h3> 
      <input type="button" name="Logout" value="Log out" onclick="window.location.href='/Login.html'">
    </div>
    </header>
    <div class="leftbar content">
      <h3>List</h3>
      <div>
        <p>Acer asphire5f 35-f342</p>
        <p>Acer asphire5f 35-f342</p>
        <p>Acer asphire5f 35-f342</p>
      </div>
    </div>
    <div class="page-main content">
      <h3>List name of the Device</h3><br>
      	<input type="text" name="" placeholder="Search here"> <div class="form-box">
        <input type="button" name="Search" value="Search" onclick="click()">
        <input type="button" name="Create" value="Create" onclick="window.location.href = '/Create.html'">
        <input type="button" name="Delete" value="Delete" onclick="click()">
      </div><br>
      form
    <table id="table" >
      <thead>
        <tr>
          <th data-field="state" data-checkbox="true">Pick up</th>
          <th data-field="name-device" data-filter-control="input" data-sortable="true" >Name of device</th>
          <th data-field="IP" data-filter-control="select" data-sortable="true">IP</th>
          <th data-field="time" data-filter-control="select" data-sortable="true">Time</th>
        </tr>
      </thead>
      <tbody>
      <%for(Clients i: listClient){ %>
        <tr>
          <td class="bs-checkbox "><input data-index="0" name="btSelectItem" type="checkbox"></td>
          <td><a href = "GotoViewDeviceServlet?nameclient=<%=i.getNameClient()%>"><%=i.getNameClient()%></a></td>
          <td><%= 123456%></td>
          <td><%= i.getLastTimeOnline().toString() %></td>
        </tr>
        <%} %>
      </tbody>
    </table>  
    </div>
    <footer align="center" class="page-footer content">
      <h3>Detect Web (c) Based on DOMjudge 5.1.3<br>
        Modified by group12 - 2021<br>
        University of Science and Technology - University of Danang
        </h3>
    </footer>
  </div>
  <%} %>
</body>
</html>