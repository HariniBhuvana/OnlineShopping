package com.shopping.OnlineShopping.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.OnlineShopping.entity.LineItem;
import com.shopping.OnlineShopping.entity.Order;
import com.shopping.OnlineShopping.exception.OrderNotFoundException;
import com.shopping.OnlineShopping.repository.OrderRepository;
import com.shopping.OnlineShopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	

	private HashMap<Integer, Set<LineItem>> map = new HashMap<>();	
	
	@Override
	public void addToCart(LineItem item, int customerId) {

		Set<LineItem>set=map.get(customerId);
		if(set==null) {
			set=new HashSet<>();
			set.add(item);
			map.put(customerId,set);
		}
		else
		{
			set.add(item);
			map.put(customerId,set);
		}
	}

	@Override
	public void removeFromCart(LineItem item, int customerId) {

		Set<LineItem>set=map.get(customerId);
		if(set!=null) {
			set.remove(item);
			map.put(customerId,set);
		}
	}

	@Override
	public Set<LineItem> getLineItems(int customerId) {

		Set<LineItem>set=map.get(customerId);
		return set;
	}
	@Override
	public Set<Order> getOrders(int customerId)   {
	return null;	
	}

	@Override
	public Order getOrder(int orderId)   {

		return orderRepository.findById(orderId).get();
	}

	@Override
	public Order submitOrder(Order order) {
		order.setStatus("Processing");
		order.setDate(LocalDate.now());
		return orderRepository.save(order);
		}
		@Override
	public Order cancelOrder(int orderId)   {

			Optional<Order> optional = orderRepository.findById(orderId);
			System.out.println(optional.get());
			if(optional.isPresent()) {
			optional.get().setStatus("Order Cancelled");
			return orderRepository.save(optional.get());
			}
			return null;		
	}

	@Override
	public Order deleteOrder(int orderId)   {

		Optional<Order> optional=orderRepository.findById(orderId);
		if(optional.isPresent()) {
			optional.get().setStatus("Order Deleted");
			return orderRepository.save(optional.get());
		}
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		
		Optional<Order> optional = orderRepository.findById(order.getOrderId());
		System.out.println(optional.get());
		if(optional.isPresent()) {
		optional.get().setStatus("Order Updated");
		return orderRepository.save(optional.get());
		}
		return null;	
	}

	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Order> getOrderByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
