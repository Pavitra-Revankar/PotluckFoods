package com.feast.PotLuckFoods.Application;

import java.util.Scanner;

import com.feast.PotLuckFoods.DAOImplementation.MenuDAOimplementation;
import com.feast.PotLuckFoods.model.Menu;

public class ApplicationMenu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dishName,imgPath,description;
		boolean isAvailable;
		int price,restaurantId;
		float ratings;
		String input;
		
		
		do {
			System.out.println("Enter your Dish Name");
			dishName = scan.nextLine();
			
			System.out.println("Enter your image path");
			imgPath = scan.nextLine();
			
			System.out.println("Enter description for the dish ");
			description = scan.nextLine();
			
			System.out.println("Enter your ratings");
			ratings = scan.nextInt();
			
			System.out.println("Enter price for the dish");
			price = scan.nextInt();
			
			System.out.println(" Dish is Available?(boolean)");
			isAvailable = scan.nextBoolean();
			
			System.out.println("Enter restaurant  id");
			restaurantId = scan.nextInt();
			
			Menu m1 = new Menu(dishName,price,description,imgPath,isAvailable,restaurantId,ratings);
			MenuDAOimplementation menuImp = new MenuDAOimplementation();
			menuImp.addMenu(m1);
			
			System.out.println("Want to enter one more user details? (yes/no)");
			input = scan.nextLine();
		}while(input.equalsIgnoreCase("yes"));

	}

}
