package com.shopping.OnlineShopping.entity;

public class LineItem {

	private int itemId;
	private int quantity;
	private Product product;
	private double price;

	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineItem(int itemId, int quantity, Product product, double price) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.product = product;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", quantity=" + quantity + ", product=" + product + ", price=" + price
				+ "]";
	}
	
	
	
}
