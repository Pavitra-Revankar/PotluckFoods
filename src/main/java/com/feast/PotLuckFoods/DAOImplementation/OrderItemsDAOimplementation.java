package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.feast.PotLuckFoods.DAO.orderItemsDAO;
import com.feast.PotLuckFoods.model.OrderItems;

public class OrderItemsDAOimplementation implements orderItemsDAO {
	
	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `orderitems`(`userId`,`menuId`,`orderItemName`,`quantity`,`price`) VALUES(?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `orderitems` WHERE `orderItemId` =?";
	final static String DELETE_QUERY = "DELETE FROM `orderitems` WHERE `menuId` = ?";
	final static String UPDATE_QUERY = "UPDATE `orderitems` SET `userId` = ? , `menuId`=?, `orderItemName` = ?, `quantity` = ? ,`ratings` = ? ,`price` = ? WHERE orderItemId = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `orderitems`";
	final static String GET_MENUID_BY_USERID = "SELECT `menuId` FROM `orderitems` WHERE `userId`=?";
	
	public OrderItemsDAOimplementation(){
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
	public int addOrderItems(OrderItems oi) {
		PreparedStatement pstmt;
		int i =-1;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1,oi.getUserId());
			pstmt.setInt(2,oi.getMenuId());
			pstmt.setString(3, oi.getOrderItemName());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setInt(5, oi.getPrice());
			
			
			i = pstmt.executeUpdate();
			if(i>0)
				System.out.println("Restaurant added successfully");
			else
				System.out.println("Counldn't add restaurant , Try Again!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public OrderItems getOrderItems(int orderItemsId) {
		PreparedStatement pstmt;
		OrderItems oi1=null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderItemsId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int id = orderItemsId;
				int userId =result.getInt("userId");
				int menuId = result.getInt("menuId");
				String orderItemName = result.getString("orderItemName");
				int quantity = result.getInt("quantity");
				int price = result.getInt("price");
				
				
				
				oi1 = new OrderItems(id,userId,menuId,orderItemName,quantity,price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return oi1;
	}

	@Override
	public void updateOrderItems(OrderItems oi) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setInt(1,oi.getUserId());
			pstmt.setInt(2,oi.getMenuId());
			pstmt.setString(3, oi.getOrderItemName());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setInt(5, oi.getPrice());	
			pstmt.setInt(6,oi.getOrderItemId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderItems(int orderItemsId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, orderItemsId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		Statement statement = null;
		ResultSet result = null;
		OrderItems oi=null;

		ArrayList<OrderItems> orderItemsList = new ArrayList<>();

		try {
			statement = con.createStatement();

			result = statement.executeQuery(SELECTALL_QUERY);

			while (result.next()) {
				int id = result.getInt("orderItemId");
				int userId =result.getInt("userId");
				int menuId = result.getInt("menuId");
				String orderItemName = result.getString("orderItemName");
				int quantity = result.getInt("quantity");
				int price = result.getInt("price");
				
				
				
				oi = new OrderItems(id,userId,menuId,orderItemName,quantity,price);
				
				orderItemsList.add(oi);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderItemsList;	
	}
	
	public Set<Integer> getMenuIdByUserId(int userId) {
		PreparedStatement pstmt;
		OrderItems oi1=null;
		HashSet<Integer> s= new HashSet<>();
		try {
			pstmt = con.prepareStatement(GET_MENUID_BY_USERID);
			
			pstmt.setInt(1, userId);
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				
				int menuId = result.getInt("menuId");
				s.add(menuId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

}
