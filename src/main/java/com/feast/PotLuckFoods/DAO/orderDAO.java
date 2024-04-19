package com.feast.PotLuckFoods.DAO;

import java.util.List;

import com.feast.PotLuckFoods.model.Order;

public interface orderDAO {
	void addOrder(Order order);
	Order getOrder(String orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	List<Order> getAllOrder();
}
