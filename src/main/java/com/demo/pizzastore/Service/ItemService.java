package com.demo.pizzastore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pizzastore.Domain.Item;


@Service
public class ItemService {
	
	@Autowired
	private PizzaService pizzaService;
	
	public List<Item> getAllItems() {
		List<Item> pizza =  pizzaService.pizzaToItem(pizzaService.getAllPizza());
		return pizza ;
	}
	
	public Item getItem(long id) {
		return pizzaService.getPizza(id);
	}
	

}
