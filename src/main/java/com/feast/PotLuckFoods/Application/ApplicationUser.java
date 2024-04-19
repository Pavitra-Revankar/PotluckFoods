package com.feast.PotLuckFoods.Application;

import java.util.Scanner;

import com.feast.PotLuckFoods.DAO.UserDAO;
import com.feast.PotLuckFoods.DAOImplementation.UserDAOimplementation;
import com.feast.PotLuckFoods.model.User;

public class ApplicationUser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String fullName,email,phone,address,username,password,role;
		String input;
		
		
		do {
			System.out.println("Enter your FullName");
			fullName = scan.nextLine();
			
			System.out.println("Enter your email");
			email = scan.nextLine();
			
			System.out.println("Enter your phone");
			phone = scan.nextLine();
			
			System.out.println("Enter your username");
			username = scan.nextLine();
			
			System.out.println("Enter your address");
			address = scan.nextLine();
			
			System.out.println("Enter your password");
			password = scan.nextLine();
			
			System.out.println("Enter your role");
			role = scan.nextLine();
			
			User user1 = new User(fullName,email,phone,address,username,password,role);
			
			UserDAOimplementation u1 = new UserDAOimplementation();
			u1.addUser(user1);
			
			System.out.println("Want to enter one more user details? (yes/no)");
			input = scan.nextLine();
		}while(input.equalsIgnoreCase("yes"));

	}

}
