package com.feast.PotLuckFoods.Application;

import java.util.List;
import java.util.Scanner;

import com.feast.PotLuckFoods.DAOImplementation.RestaurantDAOimplementation;
import com.feast.PotLuckFoods.model.Restaurant;

public class ApplicationRestaurant {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String resName,imgPath,resAddress,cuisineType;
		boolean isActive;
		int resOwnerId,ratings,ETA;
		String input;
		
		RestaurantDAOimplementation res1 = new RestaurantDAOimplementation();
		Restaurant l = res1.getRestaurant(1);
		
		
//		for(Restaurant r : l)
//			System.out.println(r.getRestaurantName());
//		do {
//			System.out.println("Enter your Restaurant Name");
//			resName = scan.nextLine();
//			
//			System.out.println("Enter your image path");
//			imgPath = scan.nextLine();
//			
//			System.out.println("Enter restaurant address");
//			resAddress = scan.nextLine();
//			
//			System.out.println("Enter your ratings");
//			ratings = scan.nextInt();
//			
//			System.out.println("Enter estimated time of delivery in minutes");
//			ETA = scan.nextInt();
//			
//			System.out.println("Enter cuisine type");
//			cuisineType = scan.nextLine();
//			
//			System.out.println(" Restaurant is active?(boolean)");
//			isActive = scan.nextBoolean();
//			
//			System.out.println("Enter restaurant owner id");
//			resOwnerId = scan.nextInt();
//			
//			Restaurant r1 = new Restaurant(resName,imgPath,ratings,ETA,cuisineType,resAddress,isActive,resOwnerId);
//			RestaurantDAOimplementation res1 = new RestaurantDAOimplementation();
//			res1.addRestaurant(r1);
//			
//			System.out.println("Want to enter one more user details? (yes/no)");
//			input = scan.nextLine();
//		}while(input.equalsIgnoreCase("yes"));

	}

}
