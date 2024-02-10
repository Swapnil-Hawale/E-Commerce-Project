package com.sg.beans;

public class CartBean {

    int cart_id;
    int user_id;
    String product_name;
    int price;
    int total_quantity;
    int total_price;
	public CartBean(int cart_id, int user_id, String product_name, int price, int total_quantity, int total_price) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_name = product_name;
		this.price = price;
		this.total_quantity = total_quantity;
		this.total_price = total_price;
	}
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
    
}
