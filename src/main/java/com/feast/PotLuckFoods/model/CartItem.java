package com.feast.PotLuckFoods.model;

import java.util.HashMap;
import java.util.Map;

public class CartItem {
	private int itemID;
	private int resId;
	private String dishName;
	private int price;
	private int quantity;
	
	public CartItem(){
		
	}
	
	

	public CartItem(int itemID, int resId, String dishName, int price, int quantity) {
		super();
		this.itemID = itemID;
		this.resId = resId;
		this.dishName = dishName;
		this.price = price;
		this.quantity = quantity;
	}


	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}


