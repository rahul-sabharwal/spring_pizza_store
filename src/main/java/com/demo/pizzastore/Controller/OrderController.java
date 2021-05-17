package com.demo.pizzastore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pizzastore.Domain.Order;
import com.demo.pizzastore.Service.OrderService;


@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	

	@PostMapping("/order")
	public Order placeOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@GetMapping("/orders")
	public List<Order> findAllOrders(){
		return orderService.getAllOrder();
	}
	
	@GetMapping("/order/id={id}")
	public Order getPizzaById(@PathVariable long id) {
		return orderService.getOrder(id);
	}

	@PostMapping("/order/update")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/order/delete/id={id}")
	public void deleteOrder(@PathVariable long id) {
		orderService.deleteOrder(id);
	}
	
}
