package com.xiahui.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	//该购物车中存储的n个购物项
	private Map<String,CartItem> CartItems = new HashMap<String,CartItem>();
	
	//商品的总计：
	private double total;

	public Map<String, CartItem> getCartItems() {
		return CartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		CartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
