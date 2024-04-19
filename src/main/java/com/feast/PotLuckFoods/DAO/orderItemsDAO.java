package com.feast.PotLuckFoods.DAO;

import java.util.List;
import java.util.Set;

import com.feast.PotLuckFoods.model.OrderItems;

public interface orderItemsDAO {
	int addOrderItems(OrderItems oi);
	OrderItems getOrderItems(int orderItemsId);
	void updateOrderItems(OrderItems oi);
	void deleteOrderItems(int orderItemsId);
	List<OrderItems> getAllOrderItems();
	Set<Integer> getMenuIdByUserId(int userId);
}
