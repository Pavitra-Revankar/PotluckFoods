package com.feast.PotLuckFoods.model;

public class OrderItems {
	private int orderItemsId;
	private int userId;
	private int menuId;
	private String orderItemName;
	private int quantity;
	private int price;
	
	public OrderItems() {
		
	}
	
	
	public OrderItems(int orderItemsId, int userId, int menuId, String orderItemName, int quantity, int price) {
		this.orderItemsId = orderItemsId;
		this.userId = userId;
		this.menuId = menuId;
		this.orderItemName = orderItemName;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	public OrderItems( int userId, int menuId, String orderItemName, int quantity, int price) {
		this.userId = userId;
		this.menuId = menuId;
		this.orderItemName = orderItemName;
		this.quantity = quantity;
		this.price = price;
		
	}


	public int getOrderItemId() {
		return orderItemsId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemsId = orderItemId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public String getOrderItemName() {
		return orderItemName;
	}


	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	
	
	
}
