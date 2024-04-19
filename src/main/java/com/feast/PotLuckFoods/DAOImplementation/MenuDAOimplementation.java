package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.feast.PotLuckFoods.DAO.menuDAO;
import com.feast.PotLuckFoods.model.Menu;
import com.feast.PotLuckFoods.model.Restaurant;

public class MenuDAOimplementation implements menuDAO{
	
	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `menu`(`dishName`,`price`,`description`,`imagePath`,`isAvailable`,`restaurantId`,`ratings`) VALUES(?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuId` =?";
	final static String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId` = ?";
	final static String UPDATE_QUERY = "UPDATE `menu` SET `dishName` = ? , `price`=?, `description` = ?, `imagePath` = ? ,`isAvailable` = ? ,`restaurantId` = ?,`ratings` = ? WHERE menuId = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `menu`";
	final static String SELECT_QUERY_BY_RESTAURANT_ID = "SELECT * FROM `menu` WHERE `restaurantId` =?";
	
	public MenuDAOimplementation(){
		String url = "jdbc:mysql://localhost:3306/maven";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMenu(Menu menu) {
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1,menu.getDishName());
			pstmt.setInt(2,menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagePath());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setInt(6,menu.getRestaurantId());
			pstmt.setFloat(7, menu.getRatings());
			
			
			int i = pstmt.executeUpdate();
			if(i>0)
				System.out.println("Restaurant added successfully");
			else
				System.out.println("Counldn't add restaurant , Try Again!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement pstmt;
		Menu m1=null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, menuId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int id = menuId;
				String dishName = result.getString("dishName");
				int price = result.getInt("price");
				String description = result.getString("description");
				String imagePath = result.getString("imagePath");
				boolean isAvailable = result.getBoolean("isAvailable");
				int restaurantId = result.getInt("restaurantId");
				float ratings = result.getFloat("ratings");
				
				m1 = new Menu(id,dishName,price,description,imagePath,isAvailable,restaurantId,ratings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m1;
	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, menu.getDishName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagePath());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setInt(6, menu.getRestaurantId());
			pstmt.setFloat(7, menu.getRatings());
			pstmt.setInt(8, menu.getMenuId());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, menuId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenu() {
		Statement statement = null;
		ResultSet result = null;
		Menu m1=null;

		ArrayList<Menu> menuList = new ArrayList<>();

		try {
			statement = con.createStatement();

			result = statement.executeQuery(SELECTALL_QUERY);

			while (result.next()) {
				int id = result.getInt("menuId");
				String dishName = result.getString("dishName");
				int price = result.getInt("price");
				String description = result.getString("description");
				String imagePath = result.getString("imagePath");
				boolean isAvailable = result.getBoolean("isAvailable");
				int restaurantId = result.getInt("restaurantId");
				float ratings = result.getFloat("ratings");
				
				
				
				m1 = new Menu(id,dishName,price,description,imagePath,isAvailable,restaurantId,ratings);
				
				menuList.add(m1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public List<Menu> getMenuByRestaurantId(int restId) {
		PreparedStatement pstmt;
		Menu m1=null;
		ArrayList<Menu> menuList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(SELECT_QUERY_BY_RESTAURANT_ID);
			
			pstmt.setInt(1, restId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("menuId");
				String dishName = result.getString("dishName");
				int price = result.getInt("price");
				String description = result.getString("description");
				String imagePath = result.getString("imagePath");
				boolean isAvailable = result.getBoolean("isAvailable");
				int restaurantId = result.getInt("restaurantId");
				float ratings = result.getFloat("ratings");
				
				m1 = new Menu(id,dishName,price,description,imagePath,isAvailable,restaurantId,ratings);
				menuList.add(m1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

}
