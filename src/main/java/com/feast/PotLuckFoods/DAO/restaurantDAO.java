package com.feast.PotLuckFoods.DAO;

import java.util.List;

import com.feast.PotLuckFoods.model.Restaurant;

public interface restaurantDAO {
	void addRestaurant(Restaurant res);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant res);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurant();
}
