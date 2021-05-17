package com.demo.pizzastore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pizzastore.Domain.Order;
import com.demo.pizzastore.Repository.OrderRepo;



@Service
public class OrderService {

	@Autowired
	public OrderRepo orderRepo;
	
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public Order getOrder(long id) {
		return orderRepo.findById(id).get();
	}
	
	public Order updateOrder(Order order) {
		Order initialorder = orderRepo.findById(order.getId()).orElse(order);
		initialorder.setCustomerName(order.getCustomerName());
		initialorder.setPizza(order.getPizza());
		return orderRepo.save(initialorder);
	}
	
	public void deleteOrder(long id) {
		orderRepo.deleteById(id);
	}
	
}
