package com.feast.PotLuckFoods.model;

import java.sql.Time;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String imagePath;
	private float ratings;
	private int ETA;
	private String cuisineType;
	private String restaurantAddress;
	private boolean isActive;
	private int restaurantOwnerId;
	
	
	public Restaurant() {
		
	}
	
	public Restaurant(int restaurantId, String restaurantName, String imagePath, float ratings, int ETA,
			String cuisineType, String restaurantAddress, boolean isActive, int restaurantOwnerId) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.ETA = ETA;
		this.cuisineType = cuisineType;
		this.restaurantAddress = restaurantAddress;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}
	
	public Restaurant(String restaurantName, String imagePath, float ratings, int ETA,
			String cuisineType, String restaurantAddress, boolean isActive, int restaurantOwnerId) {
//		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.ETA = ETA;
		this.cuisineType = cuisineType;
		this.restaurantAddress = restaurantAddress;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public int getETA() {
		return ETA;
	}

	public void setETA(int eTA) {
		ETA = eTA;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}

	
	
	
}
