<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
<%@ include file="login.css"%>
</style>
<title>Login</title>
</head>
<body>
<pre>GOOD . FOOD . GOOD . MOOD</pre>
<div class="form">

	<form action="CallResServ" method="post">
		<div class="flexContainer">
			<div class="label" ><label>UserName/Email</label></div>
			<div class="input" ><input class="textbox" type ="text" name="username" placeholder="JackWil"  required></div>
		</div>
		<br></br>
		<div class="flexContainer">	
			<div class="label"  style="margin-right:64px"><label>Password</label></div> 
			<div class="input" ><input class="textbox" type ="password" name="password" placeholder="enter your password"  required></div>
		</div>
			
			<br><br>
		<input type="submit" value="LogIn" class="btnLogin">
		<br>
	</form>
</div><br></br>
<div class="createAcc">
	<p style="color:white">New to Potluck? <span> </span><a href="register.jsp" style="color:white"> Create an account</a></p>
</div>
	<% String errorMessage =(String) request.getAttribute("errorMessage"); %>
	<% if(errorMessage!=null) { %>
		<p style="color:red"><%= errorMessage %></p>
	<% } %>


</body>
</html>