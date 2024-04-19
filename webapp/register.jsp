<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Register</title>
<style>
<%@ include file="register.css"%> 
</style>
</head>
<body>
<div class="form">
	<h1>Register</h1>
	<form action="CallRegisterServ" method="post">
		<div class="flexContainer">
			<div class="label flex-item"><label>Name</label></div>
			<div class="textbox flex-item"><input type ="text" name="name" placeholder="e.g Jack Wilson"  required><br></div>
		</div>
		
		<div class="flexContainer">
			<div class="label flex-item"><label>Email</label></div>
			<div class="textbox flex-item"><input type ="text" name="email" placeholder="e.g jack45@gmail.com" required><br></div>
		</div>
		
		<div class="flexContainer">
			<div class="label flex-item"><label>Phone</label></div>
			<div class="textbox flex-item"><input   type ="text" name="phone" placeholder="e.g 8767654323" oninput="if(this.value.length>10) this.value = this.value.slice(0,10)" required><br></div>
		</div>
		
		<div class="flexContainer">
			<div class="label flex-item"><label>UserName</label></div>
			<div class="textbox flex-item"><input type ="text" name="username" placeholder="JackWil" required><br></div>
		</div>
		
		<div class="flexContainer">
			<div class="label flex-item"><label>Password</label></div>
			<div class="textbox flex-item"><input type ="password" name="password" placeholder="Type Your Password"   required><br></div>
		</div>
		
		<div class="flexContainer">
			<div class="label flex-item"><label>Re-type Password</label></div>
			<div class="textbox flex-item"><input type ="password" name="re-password" placeholder="Re-Type Your Password"   required><br></div>
		</div>
		
		<br>
		<div >
			<input type="submit" value="Register"  class="btnRegister"></input>
		</div>
		
	</form>
	
	<div class="Acc">
		<p style="color:white">Have an account?<span> </span><a href="login.jsp" style="color:white">LogIn</a></p>
	</div>
	<% String errorMessage =(String) request.getAttribute("errorMessage"); %>
	<% if(errorMessage!=null) { %>
		<p style="color:red"><%= errorMessage %></p>
	<% } %>
</div>
</body>
</html>