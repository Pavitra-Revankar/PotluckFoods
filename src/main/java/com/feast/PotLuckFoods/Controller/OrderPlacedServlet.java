package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.DAOImplementation.OrderDAOimplementation;
import com.feast.PotLuckFoods.DAOImplementation.OrderHistoryDAOimplementation;
import com.feast.PotLuckFoods.model.Cart;
import com.feast.PotLuckFoods.model.CartItem;
import com.feast.PotLuckFoods.model.Order;
import com.feast.PotLuckFoods.model.OrderHistory;

@WebServlet("/CallOrderPlaced")
public class OrderPlacedServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String orderId = generateId();
//		System.out.println("service oid "+orderId);
		int resId = (Integer)(session.getAttribute("restaurantId"));
		int userId = (Integer)(session.getAttribute("userId"));
		int totalAmount = (Integer)(session.getAttribute("total"));
		String payment = (String) session.getAttribute("payment");
		String status = "Pending";
		Timestamp orderTime = new Timestamp(new Date().getTime());
		
		Order order = new Order(orderId,resId,userId,totalAmount,payment,status,orderTime);
		OrderDAOimplementation o=new OrderDAOimplementation();
		o.addOrder(order);
		
		OrderHistoryDAOimplementation ohi  = new OrderHistoryDAOimplementation();
		OrderHistory oh = new OrderHistory(orderId,userId);		
		ohi.addOrderHistory(oh);
		
		Cart cart = (Cart) session.getAttribute("cart");
		Map<Integer,CartItem> m= cart.getAll();
		m.clear();
		cart = null;
		session.setAttribute("map",m);
		session.setAttribute("cart",cart);
		
		RequestDispatcher rd = req.getRequestDispatcher("orderPlaced.jsp");
		rd.forward(req, resp);
	}

	private String generateId() {
		String d="";
		String m="";
		String y="";
		
		OrderDAOimplementation o=new OrderDAOimplementation();
		
		Calendar today = Calendar.getInstance();
		
		int date = today.get(Calendar.DAY_OF_MONTH);
		if(date<10)
			d = "0"+date;
		else
			d = String.valueOf(date);
		
		int month = today.get(Calendar.MONTH)+1;
		if(month <10)
			m = "0"+month;
		else
			m = String.valueOf(month);
		
		int year = today.get(Calendar.YEAR);
		
		 String id =o.getLastEntryId();
		int num = Integer.parseInt(id.substring(10))+1;
		
		if(num<10)
			return "PL"+ year + m + d + "0" + num;
	
		return "PL"+ year + m + d + num;
	}
}
