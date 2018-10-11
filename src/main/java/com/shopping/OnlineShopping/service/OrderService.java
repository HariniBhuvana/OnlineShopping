package com.shopping.OnlineShopping.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.shopping.OnlineShopping.entity.LineItem;
import com.shopping.OnlineShopping.entity.Order;
import com.shopping.OnlineShopping.exception.OrderNotFoundException;

public interface OrderService {
	public Set<Order> getOrders(int customerId) ;

	public Order getOrder(int orderId)  ;

	public Order submitOrder(Order order);

	public Order cancelOrder(int orderId)  ;

	public Order deleteOrder(int orderId)  ;

	public Order updateOrder(Order order);

	public List<Order> getOrderByCustomerId(int customerId);

	public List<Order> getOrderByDate(LocalDate date);

	public void addToCart(LineItem item, int customerId);

	public void removeFromCart(LineItem item, int customerId);

	public Set<LineItem> getLineItems(int customerId);

}
