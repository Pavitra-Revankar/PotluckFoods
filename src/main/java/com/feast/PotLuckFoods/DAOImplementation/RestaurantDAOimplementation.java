package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.feast.PotLuckFoods.DAO.restaurantDAO;
import com.feast.PotLuckFoods.model.Restaurant;


public class RestaurantDAOimplementation implements restaurantDAO{
	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `restaurant`(`restaurantName`,`imagePath`,`ratings`,`ETA`,`cuisineType`,`restaurantAddress`,`isActive`,`restaurantOwnerId`) VALUES(?,?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId` =?";
	final static String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId` = ?";
	final static String UPDATE_QUERY = "UPDATE `restaurant` SET `restaurantName` = ? , `imagePath`=?, `ratings` = ?, `ETA` = ? ,`cuisineType` = ? ,`restaurantAddress` = ?, "
			+ " `isActive` = ?, `restaurantOwnerId` = ? WHERE restaurantId = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `restaurant`";
	
	public RestaurantDAOimplementation(){
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
	public void addRestaurant(Restaurant res) {
		
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1,res.getRestaurantName());
			pstmt.setString(2,res.getImagePath());
			pstmt.setFloat(3, res.getRatings());
			pstmt.setInt(4, res.getETA());
			pstmt.setString(5, res.getCuisineType());
			pstmt.setString(6,res.getRestaurantAddress());
			pstmt.setBoolean(7, res.isActive());
			pstmt.setInt(8, res.getRestaurantOwnerId());
			
			int i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement pstmt;
		Restaurant r1=null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, restaurantId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int id = restaurantId;
				String restautrantName = result.getString("restaurantName");
				String imagePath = result.getString("imagePath");
				float ratings = result.getFloat("ratings");
				int ETA = result.getInt("ETA");
				String cuisineType = result.getString("cuisineType");
				String restaurantAddress = result.getString("restaurantAddress");
				boolean isActive = result.getBoolean("isActive");
				int restautrantOwnerId = result.getInt("restaurantOwnerId");
				
				r1 = new Restaurant(id,restautrantName,imagePath,ratings,ETA,cuisineType,restaurantAddress,isActive,restautrantOwnerId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r1;
		
	}

	@Override
	public void updateRestaurant(Restaurant res) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(UPDATE_QUERY);

			prepareStatement.setString(1, res.getRestaurantName());
			prepareStatement.setString(2, res.getImagePath());
			prepareStatement.setFloat(3, res.getRatings());
			prepareStatement.setInt(4, res.getETA());
			prepareStatement.setString(5, res.getCuisineType());
			prepareStatement.setString(6, res.getRestaurantAddress());
			prepareStatement.setBoolean(7, res.isActive());
			prepareStatement.setInt(8, res.getRestaurantOwnerId());
			prepareStatement.setInt(9, res.getRestaurantId());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, restaurantId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		Statement statement = null;
		ResultSet result = null;
		Restaurant r1=null;
		

		ArrayList<Restaurant> restaurantList = new ArrayList<>();

		try {
			statement = con.createStatement();

			result = statement.executeQuery(SELECTALL_QUERY);

			while (result.next()) {
				int id = result.getInt("restaurantId");
				String restautrantName = result.getString("restaurantName");
				String imagePath = result.getString("imagePath");
				float ratings = result.getFloat("ratings");
				int ETA = result.getInt("ETA");
				String cuisineType = result.getString("cuisineType");
				String restaurantAddress = result.getString("restaurantAddress");
				boolean isActive = result.getBoolean("isActive");
				int restautrantOwnerId = result.getInt("restaurantOwnerId");
				
				r1 = new Restaurant(id,restautrantName,imagePath,ratings,ETA,cuisineType,restaurantAddress,isActive,restautrantOwnerId);
				
				restaurantList.add(r1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantList;
	}

}
