package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.DAOImplementation.OrderItemsDAOimplementation;
import com.feast.PotLuckFoods.DAOImplementation.UserDAOimplementation;
import com.feast.PotLuckFoods.model.Cart;
import com.feast.PotLuckFoods.model.CartItem;
import com.feast.PotLuckFoods.model.OrderItems;
import com.feast.PotLuckFoods.model.User;

@WebServlet("/CallCheckoutServlet")
public class CheckoutServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
	
		UserDAOimplementation u = new UserDAOimplementation();
		int id = (Integer)(session.getAttribute("userId"));
		User user = u.getUser(id);
		String address = user.getAddress();
		
		if(address!=null || address!="") {
			req.setAttribute("address", address);
		}
		
		if(cart!=null) {
			Map<Integer,CartItem> m  = cart.getAll();
			Set<Integer> key = m.keySet();
			for(Integer i :key) {
				CartItem k = m.get(i);
				
				int userId = (Integer) session.getAttribute("userId");
				int menuId =Integer.parseInt((String) session.getAttribute("menuId"));
				String itemName = k.getDishName();
				int price = k.getPrice();
				int quantity = k.getQuantity();

				OrderItemsDAOimplementation oi = new OrderItemsDAOimplementation();
				OrderItems order = new OrderItems(userId,menuId,itemName,quantity,price);
				oi.addOrderItems(order);
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
		rd.forward(req, resp);
	}
}
