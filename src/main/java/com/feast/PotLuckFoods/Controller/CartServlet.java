package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.DAOImplementation.MenuDAOimplementation;
import com.feast.PotLuckFoods.model.Cart;
import com.feast.PotLuckFoods.model.CartItem;
import com.feast.PotLuckFoods.model.Menu;

@WebServlet("/CallCartServlet")
public class CartServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartItem c;
		HttpSession session = req.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String quantity =String.valueOf(req.getParameter("qty"));
		String menuId = req.getParameter("menuId");
		session.setAttribute("menuId", menuId);
		int resId =(int) (session.getAttribute("restaurantId"));
		int total = 0;
		
	
		MenuDAOimplementation m = new MenuDAOimplementation();
		Menu menu = m.getMenu(Integer.parseInt(menuId));
//		out.println(m.get)
	
		if(Integer.parseInt(quantity) == 1) {
			 c = new CartItem(Integer.parseInt(menuId),menu.getRestaurantId(),menu.getDishName(),menu.getPrice(),Integer.parseInt(quantity));
			 cart.addCartItem(c);
			 total = total + (Integer.parseInt(quantity) * menu.getPrice());
		}
		else {
			c = new CartItem(Integer.parseInt(menuId),menu.getRestaurantId(),menu.getDishName(),menu.getPrice(),Integer.parseInt(quantity));
			cart.addCartItem(c);
			 total = total + (Integer.parseInt(quantity) * menu.getPrice());
		}

		session.setAttribute("total", total);
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}
}
