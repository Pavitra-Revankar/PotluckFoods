<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.feast.PotLuckFoods.model.Restaurant"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
<%@include file="restaurant.css" %>
</style>
<title>Restaurats</title>
</head>
<body>
<div>
	<div class="link">
		<a href="login.jsp" class="login L" style="margin-right:100px">Login</a>
		<a href="register.jsp" class="login R">Register</a>
	</div>
	<img src="images/potluck.jpg" class="img"></img>
	<div class="heading">
		<h1 >Welcome to PotLucks</h1>
	</div>
</div>

<hr></hr>
<div>
	<h3>Top Restaurants</h3>
</div>
<div class="flex-container">
	<%
	List<Restaurant> list = (List<Restaurant>) (request.getAttribute("restaurant"));
	int cols = 5;
	for (int i=0;i<list.size();i++) {
		Restaurant r = list.get(i);
		int id = r.getRestaurantId();
	%>
	
	<a href="CallMenuServ?restaurantId=<%=String.valueOf(r.getRestaurantId()).trim()%>" style="text-decorator:none">
		<div class="flex-items">
			<img src="<%= r.getImagePath() %>" style="width: 300px; height: 300px;border-radius:10px" ></img>
			<p><b><%=r.getRestaurantName()%> | <%= r.getRatings()+"*"%></b></p>
			<p><%= r.getETA()+"mins"%></p>
		</div>
	</a>
	

	
	<%
	if((i+1)%cols ==0){
	%>
	<div style="visibility:hidden;"></div>
	<%
	}
	
	}%>
</div>

</body>
</html>