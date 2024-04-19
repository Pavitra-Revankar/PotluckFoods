package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feast.PotLuckFoods.DAOImplementation.RestaurantDAOimplementation;
import com.feast.PotLuckFoods.model.Restaurant;

@WebServlet("/CallServ1")
public class RestaurantServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOimplementation r = new RestaurantDAOimplementation();
		List<Restaurant> l = r.getAllRestaurant();
		
		
		req.setAttribute("restaurant", l);
		RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
		rd.forward(req, resp);
	}
}
