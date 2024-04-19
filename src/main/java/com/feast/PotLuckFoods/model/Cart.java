package com.feast.PotLuckFoods.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	Map<Integer,CartItem> cart ;
		
		public Cart(){
			cart =new HashMap();
		}
		
		public void addCartItem(CartItem ci){
			if(cart.containsKey(ci.getItemID())) {
				CartItem c = cart.get(ci.getItemID());
				
				int quantity = c.getQuantity();
				int updateQuantity = quantity + ci.getQuantity();
				c.setQuantity(updateQuantity);
				
				cart.put(c.getItemID(), c);
			}
			
			else {
				cart.put(ci.getItemID(), ci);
			}
		}
		
		public void updateCartItem(int itemId, int quantity) {
			
			if(cart.containsKey(itemId)) {
				CartItem c = cart.get(itemId);
				c.setQuantity(quantity);
				
				cart.put(c.getItemID(), c);
			}
			
			else {
				CartItem c = cart.get(itemId);
				c.setQuantity(quantity);
				
				cart.put(c.getItemID(), c);
			}
//			System.out.println(itemId);
//			
//			CartItem c = cart.get(itemId);
//			c.setItemID(quantity);
		}
		
		public void deleteCartItem(int itemId) {
			cart.remove(itemId);
		}
		
		public Map getAll() {
			
			return cart;
		}
}
