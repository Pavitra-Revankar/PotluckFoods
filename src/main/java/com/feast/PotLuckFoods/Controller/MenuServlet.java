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

import com.feast.PotLuckFoods.DAOImplementation.MenuDAOimplementation;
import com.feast.PotLuckFoods.DAOImplementation.RestaurantDAOimplementation;
import com.feast.PotLuckFoods.model.Menu;
import com.feast.PotLuckFoods.model.Restaurant;

@WebServlet("/CallMenuServ")
public class MenuServlet extends HttpServlet{
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAOimplementation mn = new MenuDAOimplementation();
		int resId =Integer.parseInt(req.getParameter("restaurantId"));
		RestaurantDAOimplementation r = new RestaurantDAOimplementation();
		Restaurant res = r.getRestaurant(resId);
		System.out.println(res.getRestaurantName());
		req.setAttribute("restaurant", res);
		
		List<Menu> l =mn.getMenuByRestaurantId(resId);
		
		req.setAttribute("menu", l);
		HttpSession session= req.getSession();
		session.setAttribute("restaurantId", resId);

		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);

	}
}
