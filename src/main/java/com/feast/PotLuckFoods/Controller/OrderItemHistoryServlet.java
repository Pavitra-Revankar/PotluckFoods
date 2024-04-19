package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.DAOImplementation.OrderItemsDAOimplementation;
import com.feast.PotLuckFoods.model.OrderItems;

@WebServlet("/CallOrderItemHistoryServlet")
public class OrderItemHistoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderItemsDAOimplementation oh =new OrderItemsDAOimplementation();
		
		List<OrderItems> l = oh.getAllOrderItems();
		HttpSession session = req.getSession();
		session.setAttribute("orderHistoryItems", l);
		
		RequestDispatcher rd = req.getRequestDispatcher("orderItemHistory.jsp");
		rd.forward(req, resp);
	}
}
