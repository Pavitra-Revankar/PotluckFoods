package com.feast.PotLuckFoods.DAO;

import java.util.List;

import com.feast.PotLuckFoods.model.User;

public interface UserDAO {
	int addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	String getUserByName(String userName);
	int updateAddress(int userId, String address);
}
