package com.feast.PotLuckFoods.model;

public class Menu {
	private int menuId;
	private String dishName;
	private int price;
	private String description;
	private String imagePath;
	private boolean isAvailable;
	private int restaurantId;
	private float ratings;
	
	public Menu() {
		
	}
	
	public Menu(int menuId, String dishName, int price, String description, String imagePath, boolean isAvailable,
			int restaurantId, float ratings) {
		this.menuId = menuId;
		this.dishName = dishName;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.ratings = ratings;
	}
	
	public Menu(String dishName, int price, String description, String imagePath, boolean isAvailable,
			int restaurantId, float ratings) {
		this.dishName = dishName;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.ratings = ratings;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	
	
	
}
