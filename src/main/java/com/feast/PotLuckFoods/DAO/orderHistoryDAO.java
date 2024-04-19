package com.feast.PotLuckFoods.DAO;

import java.util.List;

import com.feast.PotLuckFoods.model.OrderHistory;
import com.feast.PotLuckFoods.model.OrderItems;

public interface orderHistoryDAO {
	void addOrderHistory(OrderHistory oh);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory oh);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getOrderHistory();
}
