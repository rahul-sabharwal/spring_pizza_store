package com.demo.pizzastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pizzastore.domain.Order;
import com.demo.pizzastore.dto.OrderDto;
import com.demo.pizzastore.mapper.OrderConverter;
import com.demo.pizzastore.service.OrderService;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired 
	private OrderConverter converter;
	

	@GetMapping()
	public List<OrderDto> findAllOrders(){
		return converter.toDto(orderService.getAllOrder());
	}
	
	@PostMapping()
	public OrderDto placeOrder(@RequestBody OrderDto dto) {
		Order order = converter.toEntity(dto);
		return converter.toDto(orderService.addOrder(order));
	}
	

	@PostMapping("/{id}")
	public OrderDto updateOrder(@RequestBody Order order) {
		return converter.toDto(orderService.updateOrder(order));
	}
	
	
	@GetMapping("/{id}")
	public OrderDto getOrderById(@PathVariable long id) {
		return converter.toDto(orderService.getOrder(id));
	}

	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable long id) {
		orderService.deleteOrder(id);
	}
	
}
