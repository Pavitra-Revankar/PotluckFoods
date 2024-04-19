<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.feast.PotLuckFoods.model.OrderItems, com.feast.PotLuckFoods.model.Menu, java.util.List, java.util.Set, com.feast.PotLuckFoods.DAOImplementation.OrderItemsDAOimplementation,
    com.feast.PotLuckFoods.DAOImplementation.MenuDAOimplementation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Order History</title>
<style>
.items{
	width:500px;
	height:100px;
	margin:20px;
	margin-bottom: 100px;
	padding-bottom:0px;
	float:top;
}
span{
	padding-left: 10px;
	
}

h1{
margin-bottom:60px;
}
</style>
</head>
<body>
<div>
	<h1 style="margin-top:100px;margin-left:30px">You Previously Ordered</h1><hr></hr>
		<%
		List<OrderItems> list = (List<OrderItems>) (session.getAttribute("orderHistoryItems"));
		OrderItemsDAOimplementation o = new OrderItemsDAOimplementation();
		MenuDAOimplementation m = new MenuDAOimplementation();
		Set<Integer> menuId = o.getMenuIdByUserId((Integer)session.getAttribute("userId"));
		for (int id : menuId) {
			Menu menu = m.getMenu(id);
			
		%>
		
		<div class="items" style="border:2px solid white;border-radius:10px; margin:20px;">			
				<img src="<%= menu.getImagePath() %>" style="width: 100px; height: 100px;border-radius:10px;float:left" ></img>
				<span style="clear:float"><b><%=menu.getDishName()%> | <%= menu.getRatings()+"*"%></b></span>
		</div>
		</div>
		
		<%
		}
		%>
	</div>
</div>
</body>
</html>

