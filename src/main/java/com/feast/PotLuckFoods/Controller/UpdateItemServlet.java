package com.feast.PotLuckFoods.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.model.Cart;
@WebServlet("/CallUpdateItemServlet")
public class UpdateItemServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quantity = Integer.parseInt(req.getParameter("qty"));
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		System.out.print("quant "+quantity);
		cart.updateCartItem(itemId, quantity);
		
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}
}
