package com.feast.PotLuckFoods.Controller;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feast.PotLuckFoods.DAOImplementation.RestaurantDAOimplementation;
import com.feast.PotLuckFoods.DAOImplementation.UserDAOimplementation;
import com.feast.PotLuckFoods.model.EncryptDecrypt;
import com.feast.PotLuckFoods.model.Restaurant;

@WebServlet("/CallResServ")
public class RestaurantServlet2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		System.out.println(username);
		
		UserDAOimplementation user =new UserDAOimplementation();
		String pass = user.getUserByName(username);
		String epass = EncryptDecrypt.decrypt(pass);
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		
		RestaurantDAOimplementation r = new RestaurantDAOimplementation();
		List<Restaurant> l = r.getAllRestaurant();
		session.setAttribute("restaurant", l);
		if(password.equals(epass)) {
			req.setAttribute("username", username);
			req.setAttribute("errorMessage","");
			int userId = user.getIdByName(username);
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			
			Timestamp loginTime = new Timestamp(new Date().getTime());
			user .updateLastLogin(loginTime, userId);
			
			RequestDispatcher rd = req.getRequestDispatcher("restaurant1.jsp");
			rd.forward(req,resp);
		}
		else {
			req.setAttribute("errorMessage","Incorrect username or password! Try Again.");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			
			
		}
	}
}