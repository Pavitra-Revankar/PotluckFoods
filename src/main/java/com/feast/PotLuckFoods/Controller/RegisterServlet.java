package com.feast.PotLuckFoods.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feast.PotLuckFoods.DAOImplementation.UserDAOimplementation;
import com.feast.PotLuckFoods.model.EncryptDecrypt;
import com.feast.PotLuckFoods.model.User;

@WebServlet("/CallRegisterServ")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("re-password");
		
		int result=-1;
//		User user1 = new User(name,email,phone,username,password);
		
//		String Ename = EncryptDecrypt.encrypt(username);
//		System.out.println(Ename);
		String Epassword = EncryptDecrypt.encrypt(password);
		
		if(password.equals(confirmPassword)) {
			User user = new User(name,email,phone,username,Epassword);
			UserDAOimplementation u1 = new UserDAOimplementation();
			result = u1.addUser(user);
		}
		else {
			req.setAttribute("errorMessage", "Password do not match. Try again");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
		}
		
		
		if(result>0) {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

	
}
