package com.feast.PotLuckFoods.DAO;

import java.util.List;

import com.feast.PotLuckFoods.model.Menu;

public interface menuDAO {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	List<Menu> getMenuByRestaurantId(int restaurantId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenu();
}
