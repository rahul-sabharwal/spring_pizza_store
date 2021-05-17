package com.demo.pizzastore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pizzastore.domain.Item;
import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.repository.PizzaRepo;


@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;

	public PizzaService() {
		System.out.println("Service Created");
	}
	
	public List<Pizza> getAllPizza() {
		List<Pizza> pizza =  pizzaRepo.findAll();
		return pizza ;
	}
	
	public Pizza getPizza(long id) {
		return pizzaRepo.findById(id).get();
	}
	
	public Pizza addPizza(Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	public Pizza updatePizza(Pizza pizza) {
		Pizza initpizza = pizzaRepo.findById(pizza.getId()).orElse(pizza);
		initpizza.setCrust(pizza.getCrust());
		initpizza.setSize(pizza.getSize());
		initpizza.setToppings(pizza.getToppings());
		return pizzaRepo.save(initpizza);
	}
	
	public void deletePizza(long id) {
		pizzaRepo.deleteById(id);
	}
	
	public Item pizzaToItem(Pizza pizza) {
		Item item = new Pizza();
		item = pizza;
		return item;
	}
	
	public List<Item> pizzaToItem(List<Pizza> pizza){
		return pizza.stream().map(i -> pizzaToItem(i)).collect(Collectors.toList());
	}
	
	
}
