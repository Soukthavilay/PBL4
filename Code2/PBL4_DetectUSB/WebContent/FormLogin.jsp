<%@page import="model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%-- <script src="app.js"></script> --%>
    <link rel="stylesheet" href="Login.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Login to DetecWeb </title>
</head>
<body>
<%
	Account a = (Account)request.getSession().getAttribute("account");
	if (a!= null){
		response.sendRedirect("FormServer.jsp");}
	else{
%>
  <div class="form">
      <h2> Login </h2>
      <form action = "GotoFromServer" method = "post">
      <div class="form-content">
          <div class="form-box">
              <label>Username</label>
              <input type="text" name="username" placeholder="email.com">
          </div>
          <div class="form-box">
              <label>Password</label>
              <input type="password" name="password" placeholder="********">
          </div>
          <div class="form-box">
              <input type="submit" id="submit" value="Login">
          </div>
          <p class="form-forget">Forget your password <a href="#">click here</a></p>
      </div>
      </form>

    </div>
    <%} %>
</body>
</html>