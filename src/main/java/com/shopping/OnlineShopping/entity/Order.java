package com.shopping.OnlineShopping.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="Order")
public class Order {
	@Id
	private int orderId;
	private double total;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate date;
	private String status;
	private Set<LineItem> items;
	private int customerId;
	public Order(int orderId, double total, LocalDate date, String status, Set<LineItem> items, int customerId) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.date = date;
		this.status = status;
		this.items = items;
		this.customerId = customerId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<LineItem> getItems() {
		return items;
	}
	public void setItems(Set<LineItem> items) {
		this.items = items;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", date=" + date + ", status=" + status + ", items="
				+ items + ", customerId=" + customerId + "]";
	}
	
	
	
	
	

}
