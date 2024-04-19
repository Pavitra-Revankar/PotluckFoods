package com.feast.PotLuckFoods.model;

public class OrderHistory {
	private int orderHistoryId;
	private String orderId;
	private int userId;
	
	public OrderHistory() {
		
	}
	
	public OrderHistory(int orderHistoryId, String orderId, int userId) {
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
	}
	
	public OrderHistory( String orderId, int userId) {
		this.orderId = orderId;
		this.userId = userId;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
