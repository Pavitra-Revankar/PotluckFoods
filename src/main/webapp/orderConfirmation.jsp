<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="com.feast.PotLuckFoods.model.Cart, com.feast.PotLuckFoods.model.CartItem, java.util.Map, java.util.Set" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
<%@ include file="orderConfirmation.css"%>
</style>
<title>Order Confirmation</title>
</head>
<body>
<h1 style="text-align:center;margin:30px;font-size:50px">Thank you for your order</h1>
		<table >
			<tr class="rows">
				<th></th>
				<th>Items</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>
			</tr>

<%	
	int count =0;
	session.setAttribute("count",count);
	Cart cart = (Cart) session.getAttribute("cart");
	int total =0;
	session.setAttribute("total", total);
	if(cart!=null){
		Map<Integer,CartItem> m = cart.getAll();
		Set<Integer> key = m.keySet();
	
		for(int i:key){
			session.setAttribute("count",++count);
			CartItem item = m.get(i);
			total = total + (item.getPrice()*item.getQuantity());
			int itemTotal = (item.getPrice()*item.getQuantity());
			session.setAttribute("itemTotal",itemTotal);
			session.setAttribute("total",total);
	%>
			<tr class="rows">
				<td class="right-align"><%=session.getAttribute("count")%></td>
				<td><%=item.getDishName()%></td>
				<td class="right-align">x <%=item.getQuantity()%></td>
				<td class="right-align">Rs. <%=item.getPrice()%></td>
				<td class="right-align">Rs. <%=session.getAttribute("itemTotal")%></td>
			</tr>		
<%
	}
}
%>
<tr style="background-color:grey;color:white">
	<td></td>
	<td>Grand Total</td>
	<td></td>
	<td></td>
	<td class="right-align">Rs. <%= session.getAttribute("total")%></td>
</tr>
</table><br /><br></br>
<div>
<form action="CallOrderPlaced">
<input type="submit" value="Confirm Order"></input>
</form>
</div>
</body>
</html>