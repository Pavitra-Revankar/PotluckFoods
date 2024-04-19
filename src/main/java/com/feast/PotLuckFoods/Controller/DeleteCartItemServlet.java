package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.model.Cart;
import com.feast.PotLuckFoods.model.CartItem;
@WebServlet("/CallDeleteCartItem")
public class DeleteCartItemServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("itemId"));
		HttpSession session  =req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart!=null) {
			cart.deleteCartItem(id);
		}
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}
}
