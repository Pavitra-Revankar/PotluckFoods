<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List , com.feast.PotLuckFoods.model.Menu, com.feast.PotLuckFoods.model.Restaurant" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menus</title>
<style>
<%@include file="menu.css" %>
</style>
</head>
<body>
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
<%
Restaurant r = (Restaurant)request.getAttribute("restaurant");

%>
<div class="info">
	<center>
		<h1 style="font-size: 100px;padding-top:40px; margin: 0px"><%=r.getRestaurantName() %></h1>

		<div class="CR">
			<span id="cuisine"><%= r.getCuisineType()%></span>
			<span id="ratings"><%= r.getRatings()+"*"%></span>
		</div>
		
		<div class="EA">
			<img src="images/timer.png" id="timer"><span id="eta"><%= r.getETA() + "mins"%></span>
			<span>|</span>
			<span id="address"><%= r.getRestaurantAddress()%></span>
		</div>
	</center>
</div>


<div>
<div class="recommended">
<p style="font-size:30px;padding-left:20px"><b>Recommended</b></p>
</div>	

<div class="flex-container">	
	<%
	List<Menu> list = (List<Menu>) (request.getAttribute("menu"));
	int cols=5;
	for (int i =0;i<list.size();i++) {
		Menu m = list.get(i);
	%>

	<form action="CallCartServlet?menuId=<%=String.valueOf(m.getMenuId())%>" method="post">
		<div class="flex-items">
			<img src="<%= m.getImagePath() %>" style="width: 300px; height: 300px;border-radius:10px" ></img>
			<p><b><%=m.getDishName()%> | <%= m.getRatings()+"*"%></b></p>
			<p><%= m.getDescription()%></p>
			<p><%= "Rs."+m.getPrice()%></p>
			<label>Qty</label><input type="number" name= "qty" min='1' value='1' style="width:50px">
			<input type="submit" value="ADD" >
		</div>
	</form>
			
	
	<%
	if((i+1)%cols ==0){
	%>
	<div style="visibility:hidden;"></div>

	<%
	}
	}
	%>
</div>
</body>
</html>