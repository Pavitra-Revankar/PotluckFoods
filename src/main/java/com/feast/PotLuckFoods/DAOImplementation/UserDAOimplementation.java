package com.feast.PotLuckFoods.DAOImplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.feast.PotLuckFoods.DAO.UserDAO;
import com.feast.PotLuckFoods.model.User;

public class UserDAOimplementation implements UserDAO{
	
	private static Connection con;
	final static String INSERT_QUERY = "INSERT INTO `users`(`name`,`email`,`phoneNumber`,`userName`,`password`) VALUES (?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * FROM `users` WHERE id = ?";
	final static String UPDATE_QUERY = "UPDATE `users` SET `name` = ? , `phoneNumber`=?, `userName` = ?, `password` = ? ,`email` = ? ,`address` = ?, `role` = ? WHERE id=?";
	final static String DELETE_QUERY = "DELETE FROM `users` WHERE `id` = ?";
	final static String SELECTALL_QUERY = "SELECT * FROM `users`";
	final static String SELECT_QUERY_BY_USERNAME = "SELECT password FROM `users` WHERE userName = ? Or email=?";
	final static String GET_ID_BY_USERNAME = "SELECT id FROM `users` WHERE userName = ? Or email=?";
	final static String UPDATE_ADDRESS = "UPDATE `users` SET `address`=? WHERE `id` = ?";
	final static String UPDATE_LOGIN_TIME = "UPDATE `users` SET `lastLogin`=? WHERE `id` = ?";
	public UserDAOimplementation() {
		String url = "jdbc:mysql://localhost:3306/maven";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public  int addUser(User user) {
		int result=-1;
		PreparedStatement prepareStatement = null;

		try {
			
			prepareStatement = con.prepareStatement(INSERT_QUERY);
			

			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPhoneNumber());
//			prepareStatement.setString(4, user.getAddress());
			prepareStatement.setString(4, user.getUserName());
			prepareStatement.setString(5, user.getPassword());
//			prepareStatement.setString(7, user.getRole());
			
			result =prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	@Override
	public User getUser(int userId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		User user = null;

		try {
			prepareStatement = con.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, userId);

			res = prepareStatement.executeQuery();
			while (res.next()) {
				int id  = userId;
				String name = res.getString("name");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phone = res.getString("phoneNumber");
				String userName = res.getString("userName");
				String role = res.getString("role");
				Date createDate = res.getDate("createDate");
				Date lastLogin = res.getDate("lastLogin");
				

				user = new User(id, name, email, phone, address, userName, password, role, createDate, lastLogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(UPDATE_QUERY);

			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getPhoneNumber());
			prepareStatement.setString(3, user.getUserName());
			prepareStatement.setString(4, user.getPassword());
			prepareStatement.setString(5, user.getEmail());
			prepareStatement.setString(6, user.getAddress());
			prepareStatement.setString(7, user.getRole());
			prepareStatement.setInt(6, user.getUserId());
			
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, userId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {

		Statement statement = null;
		ResultSet res = null;

		ArrayList<User> userList = new ArrayList<>();

		try {
			statement = con.createStatement();

			res = statement.executeQuery(SELECTALL_QUERY);

			while (res.next()) {
				int userId = res.getInt("usesrId");
				String name = res.getString("name");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String phone = res.getString("phonenumber");
				String role = res.getString("role");
				Date createDate = res.getDate("createDate");
				Date lastLogin = res.getDate("lastLogin");

				User user = new User(name,email,phone,address,userName, password,role);
				userList.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public String getUserByName(String name) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		String  pass="";

		try {
			prepareStatement = con.prepareStatement(SELECT_QUERY_BY_USERNAME);

			prepareStatement.setString(1, name);
			prepareStatement.setString(2, name);

			res = prepareStatement.executeQuery();
			while (res.next()) {
				pass = res.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pass;
	}
	
	public int getIdByName(String name) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		int  id=0;

		try {
			prepareStatement = con.prepareStatement(GET_ID_BY_USERNAME);

			prepareStatement.setString(1, name);
			prepareStatement.setString(2, name);

			res = prepareStatement.executeQuery();
			while (res.next()) {
				id = res.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
	
	public int updateAddress(int id, String address) {
		PreparedStatement pstmt = null;
		int res=-1;
		try {
			pstmt = con.prepareStatement(UPDATE_ADDRESS);
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int updateLastLogin(Timestamp loginTime,int id) {
		PreparedStatement pstmt = null;
		int res=-1;
		try {
			pstmt = con.prepareStatement(UPDATE_LOGIN_TIME);
			pstmt.setTimestamp(1, loginTime);
			pstmt.setInt(2, id);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
