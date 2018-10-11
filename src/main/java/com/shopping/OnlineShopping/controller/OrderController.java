package com.shopping.OnlineShopping.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.OnlineShopping.entity.LineItem;
import com.shopping.OnlineShopping.entity.Order;
import com.shopping.OnlineShopping.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	private HashMap<Integer,Set<LineItem>> cartItems;
	
	@PostMapping("/shop/{customerId}")
	public ResponseEntity<Set<LineItem>> addToCart(@RequestBody LineItem item, @PathVariable int customerId) {
		Set<LineItem> sampleItem = cartItems.get(customerId);
		if (sampleItem == null) {
			sampleItem = new HashSet<>();
			sampleItem.add(item);
			cartItems.put(customerId, sampleItem);
		} else {
			sampleItem.add(item);
			cartItems.put(customerId, sampleItem);
		}
		return new ResponseEntity<Set<LineItem>>(sampleItem, HttpStatus.OK);
	}
		
	
	@GetMapping("/shop{customerId}")
	public ResponseEntity<Set<LineItem>> getLineItems(@PathVariable int customerId) {
		Set<LineItem> sampleItem = cartItems.get(customerId);
		return new ResponseEntity<Set<LineItem>>(sampleItem, HttpStatus.OK);
	}

	@DeleteMapping("/shop/{customerId}")
	public ResponseEntity<Set<LineItem>> removeFromCart(@PathVariable int customerId, @RequestBody LineItem item) {
		Set<LineItem> sampleItem = cartItems.get(customerId);
		if (sampleItem != null) {
			sampleItem.remove(item);
			cartItems.put(customerId, sampleItem);
		}
		return new ResponseEntity<Set<LineItem>>(sampleItem, HttpStatus.OK);
	
	}
	@PostMapping("/shop/order")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);

	}
	@PutMapping("/shop/order/cancel")
	public ResponseEntity<Order> cancelOrder(@RequestParam int orderId){
		return new ResponseEntity<Order>(orderService.cancelOrder(orderId),HttpStatus.OK);
	}
	@PutMapping("/order")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
	}

	@DeleteMapping("/shop/order")
	public ResponseEntity<Order> deleteOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.deleteOrder(order.getOrderId()),HttpStatus.OK);
	}
	@GetMapping("/shop/order/{id}")
	public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable int customerId){
		return new ResponseEntity<List<Order>>(orderService.getOrderByCustomerId(customerId),HttpStatus.OK);
	}
	
	
	
	
}
