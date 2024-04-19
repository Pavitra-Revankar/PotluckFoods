<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.feast.PotLuckFoods.model.Cart , java.util.Map, com.feast.PotLuckFoods.model.CartItem, java.util.Set" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cart</title>
<style>
<%@include file="cart.css" %>
</style>
</head>
<body>
<nav class="navbar">
			<div class="navdiv">	
				<div >PotLuckFoods</div>
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
<h1>Your Cart</h1>	
<%
Cart cart = (Cart) session.getAttribute("cart");
if(cart!=null){
	Map<Integer, CartItem> map= cart.getAll();
	session.setAttribute("map", map);
	Set<Integer> key = map.keySet();
	for(int i:key){
		CartItem item = map.get(i);
%>	
	
	<hr></hr>
	<div >
		<span class="name"  style="width:500px;"><b><%= item.getDishName() %></b></span>
		<span  style="width:300px">Rs.<%= item.getPrice() +"/Qty"%></span>
		
		
		<form action="CallUpdateItemServlet" method="post"> 
			<label>Qty</label>
			<input type="text" name="itemId" value="<%=item.getItemID()%>" style="display:none"></input>
			<input style="width:50px;" type="number" name="qty" value=<%= item.getQuantity()%> min='1' onchange="this.form.submit()"></input>
		</form>
		<span  style="width:300px;margin-left:300px">Rs.<%= item.getPrice()* item.getQuantity()%></span>
		<br>
		<a href="CallDeleteCartItem?itemId=<%=String.valueOf(item.getItemID())%>"><input id="delete" type="submit" value="Delete"></input></a>
	</div>
		
	

<% 
	} 

%>
<br><br>

<a href="CallMenuServ?restaurantId=<%=session.getAttribute("restaurantId")%>"><input id="add" type="submit" value="Add More"></input></a>

<a href="CallCheckoutServlet"><input type="submit" id="checkout" value="Proceed to Checkout"></input></a>


<%
}
else{
	
%>	
	<center style="margin-top:150px">
		<img src="images/cart.jpg" ></img>
		<h1 class="empty">Your Cart Is Empty!</h1>
		<a href="restaurant1.jsp"><input type="submit" class="res" value="RESTAURANTS NEAR YOU"></input></a>
	</center>
<%
	}

%>
</body>
</html>