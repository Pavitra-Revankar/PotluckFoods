package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.feast.PotLuckFoods.DAO.orderDAO;
import com.feast.PotLuckFoods.model.Menu;
import com.feast.PotLuckFoods.model.Order;

public class OrderDAOimplementation implements orderDAO{

	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `order`(`orderId`,`restaurantId`,`userId`,`totalAmount`,`modeOfPayment`,`orderStatus`,`orderDate`) VALUES(?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `order` WHERE `orderId` =?";
	final static String DELETE_QUERY = "DELETE FROM `order` WHERE `orderId` = ?";
	final static String UPDATE_QUERY = "UPDATE `order` SET `restaurantId` = ? , `userId`=?, `totalAmount` = ?, `modeOfPayment` = ? ,`orderStatus` = ? WHERE orderId = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `order`";
	final static String LAST_ROW = "SELECT `orderId` FROM `order` ORDER BY `orderId` LIMIT 1";
	
	public OrderDAOimplementation(){
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
	public void addOrder(Order order) {
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1,order.getOrderId());
			pstmt.setInt(2,order.getRestaurantId());
			pstmt.setInt(3,order.getUserId());
			pstmt.setInt(4, order.getTotalAmount());
			pstmt.setString(5, order.getModeOfPayment());
			pstmt.setString(6, order.getOrderStatus());
			pstmt.setTimestamp(7, order.getOrderTime());
			
			
			int i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrder(String orderId) {
		PreparedStatement pstmt;
		Order o1=null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setString(1, orderId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				String id = orderId;
				int restaurantId = result.getInt("restaurantId");
				int userId = result.getInt("userId");
				int totalAmount = result.getInt("totalAmount");
				String modeOfPayment = result.getString("modeOfPayment");
				String orderStatus = result.getString("orderStatus");
				
				o1 = new Order(id,restaurantId,userId,totalAmount,modeOfPayment,orderStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o1;
	}

	@Override
	public void updateOrder(Order order) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setInt(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getOrderStatus());
			pstmt.setString(6, order.getOrderId());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, orderId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Order> getAllOrder() {
		Statement statement = null;
		ResultSet result = null;
		Order o1=null;

		ArrayList<Order> menuList = new ArrayList<>();

		try {
			statement = con.createStatement();

			result = statement.executeQuery(SELECTALL_QUERY);

			while (result.next()) {
				String id = result.getString("orderId");
				int restaurantId = result.getInt("restaurantId");
				int userId = result.getInt("userId");
				int totalAmount = result.getInt("totalAmount");
				String modeOfPayment = result.getString("modeOfPayment");
				String orderStatus = result.getString("orderStatus");
				
				o1 = new Order(id,restaurantId,userId,totalAmount,modeOfPayment,orderStatus);
				
				menuList.add(o1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;
	}

	public String getLastEntryId() {
		Statement stmt = null;
		ResultSet res =null;
		String id=null;
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(LAST_ROW);
			
			while(res.next()) {
				id = res.getString("orderId");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
		return id;
				
	}

}
