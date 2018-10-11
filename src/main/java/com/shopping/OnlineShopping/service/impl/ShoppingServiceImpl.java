/*package com.shopping.OnlineShopping.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.shopping.OnlineShopping.entity.Order;
import com.shopping.OnlineShopping.exception.OrderNotFoundException;
import com.shopping.OnlineShopping.repository.ShoppingRepository;
import com.shopping.OnlineShopping.service.ShoppingService;
@Service
public class ShoppingServiceImpl implements ShoppingService{

	
	@Override
	public Order addOrder(Order order) {
		return shoppingRepository.save(order);
	}

	@Override
	public Optional<Order> submitOrder(Order order)throws OrderNotFoundException {
		return shoppingRepository.findAll(List<order>);
		 
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Order order) {
	 shoppingRepository.delete(order);
	
	}

	@Override
	public void cancelOrder(int orderId) {
		 shoppingRepository.deleteById(orderId);
	}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/