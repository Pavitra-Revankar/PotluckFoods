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

import com.feast.PotLuckFoods.DAOImplementation.UserDAOimplementation;
import com.feast.PotLuckFoods.model.Cart;
import com.feast.PotLuckFoods.model.CartItem;
import com.feast.PotLuckFoods.model.User;


@WebServlet("/CallOrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		UserDAOimplementation u = new UserDAOimplementation();
		
		int id = (Integer)(session.getAttribute("userId"));

		User user = u.getUser(id);
		String address = user.getAddress();

	
		String flat = req.getParameter("flat");
		String area = req.getParameter("area");
		String landmark = req.getParameter("landmark");
		String city = req.getParameter("city");
		String pincode = req.getParameter("pincode");
		String state = req.getParameter("state");
		
		
		address = flat +"," + area +"," + city +"," +pincode+"," +state+","; 
		
		u.updateAddress(id,address);	
		
		String payment = req.getParameter("payment");
		session.setAttribute("payment",payment);
		
		RequestDispatcher rd = req.getRequestDispatcher("orderConfirmation.jsp");
		rd.forward(req, resp);
	}
}
