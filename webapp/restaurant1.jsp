<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.feast.PotLuckFoods.model.Restaurant,java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome</title>
<style>
<%@include file="restaurant1.css" %>
</style>
</head>
<body>
<div style="align=items:center">

	<!--  <div class="link">
		<img src="images/cart.png" style="width:30px;height:30px"></img>
		<a href="cart.jsp" class="cart">Cart</a>
		<img src="images/history.png" style="width:30px;height:30px"></img>
		<a href="CallOrderItemHistoryServlet" class="order">Orders</a>
	</div>-->
	<br></br>
	<div class="heading">
		<div class="divhead">
			<img class="img" src="images/potluck.jpg" style="width:100px,height:100px"></img>
			<h1 >Welcome to PotLucks <%= (String)(session.getAttribute("username")) %></h1>
		</div>
	</div>
	
		<nav class="navbar">
			<div class="navdiv">	
				<div></div>
				<ul>
					<li><a>Home</a></li>
					<li>|</li>
					<li><a href="cart.jsp" class="cart">Cart</a></li>
					<li>|</li>
					<li><a href="CallOrderItemHistoryServlet" class="order">Order History</a></li>
					<li>|</li>
					<li><a>Profile</a></li>
					<li>|</li>
					<li><a>Help</a></li>
					<li>|</li>
					<li><a>Contact</a></li>
				</ul>
			</div>
		</nav>

	
</div>

<div>
	<h3>Top Restaurants</h3>
</div>

<div  class="flex-container">	
	<%
		List<Restaurant> list = (List<Restaurant>) (session.getAttribute("restaurant"));
		int cols =5;
		for (int i=0;i<list.size();i++) {
			Restaurant r = list.get(i);
			int id = r.getRestaurantId();
			%>
		
		<a href="CallMenuServ?restaurantId=<%=String.valueOf(r.getRestaurantId()).trim()%>" style="text-decorator:none">
			<div class="flex-items">
				<img src="<%= r.getImagePath() %>" style="width: 300px; height: 300px;border-radius:10px" ></img>
				<p><b><%=r.getRestaurantName()%> | <%= r.getRatings()+"*"%></b></p>
				<p style="margin:0px"><%= r.getETA()+"mins"%></p>	
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
</div>
</body>
</html>