package com.sg.beans;

public class OrderBean {
	
	int sr_no;
	int order_id;
	String product_name;
	int price;
	int total_quantity;
	int total_price;
	int user_id;
	
	public OrderBean(int sr_no, int order_id, String product_name, int price, int total_quantity, int total_price,
			int user_id) {
		super();
		this.sr_no = sr_no;
		this.order_id = order_id;
		this.product_name = product_name;
		this.price = price;
		this.total_quantity = total_quantity;
		this.total_price = total_price;
		this.user_id = user_id;
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
