package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.feast.PotLuckFoods.DAO.orderHistoryDAO;
import com.feast.PotLuckFoods.model.Menu;
import com.feast.PotLuckFoods.model.OrderHistory;
import com.feast.PotLuckFoods.model.OrderItems;

public class OrderHistoryDAOimplementation implements orderHistoryDAO{
	
	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `orderhistory`(`orderId`,`userId`) VALUES(?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `orderhistory` WHERE `orderHistoryId` =?";
	final static String DELETE_QUERY = "DELETE FROM `orderhistory` WHERE `orderHistoryId` = ?";
	final static String UPDATE_QUERY = "UPDATE `orderhistory` SET `orderId` = ? , `menuId`=? WHERE orderHistoryId = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `orderhistory`";
	
	public OrderHistoryDAOimplementation(){
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
	public void addOrderHistory(OrderHistory oh) {
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1,oh.getOrderId());
			pstmt.setInt(2,oh.getUserId());
			
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
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement pstmt;
		OrderHistory oh=null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderHistoryId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int id = orderHistoryId;
				int userId = result.getInt("userId");
				String orderId = result.getString("orderId");
				
				oh = new OrderHistory(id,orderId,userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return oh;
	}

	@Override
	public void updateOrderHistory(OrderHistory oh) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1,oh.getOrderId());
			pstmt.setInt(2,oh.getUserId());
			pstmt.setInt(8, oh.getOrderHistoryId());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, orderHistoryId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getOrderHistory() {
		Statement statement = null;
		ResultSet result = null;
		OrderHistory oh=null;

		ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();

		try {
			statement = con.createStatement();

			result = statement.executeQuery(SELECTALL_QUERY);

			while (result.next()) {
				int id = result.getInt("orderHistoryId");
				String orderId = result.getString("orderId");
				int userId = result.getInt("userId");
				
				oh = new OrderHistory(id,orderId,userId);
				
				orderHistoryList.add(oh);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderHistoryList;

	}

}
