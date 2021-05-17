package com.demo.pizzastore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.pizzastore.Converter.PizzaConverter;
import com.demo.pizzastore.Domain.Pizza;
import com.demo.pizzastore.Dto.PizzaDto;
import com.demo.pizzastore.Service.PizzaService;


public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private PizzaConverter converter;
	
	//	get pizza
	@GetMapping("/allpizza")
	public List<PizzaDto> getAllPizzas(){
		return converter.entityToDto(pizzaService.getAllPizza());
	}
	
	@PostMapping("/addpizza")
	public PizzaDto addPizza(@RequestBody PizzaDto dto) {
		Pizza pizza = converter.dtoToEntity(dto);
		pizza = pizzaService.addPizza(pizza);
		return converter.entityToDto(pizzaService.addPizza(pizza)); 
	}
	
	@GetMapping("/pizza/{id}")
	public PizzaDto getPizza(@PathVariable long id) {
		return converter.entityToDto(pizzaService.getPizza(id));
	}
//
	@PostMapping("/pizza/update")
	public PizzaDto updateSideDish(@RequestBody Pizza pizza) {
		return converter.entityToDto(pizzaService.updatePizza(pizza));
	}
	
	@DeleteMapping("/pizza/delete/{id}")
	public void deleteSideDish(@PathVariable long id) {
		pizzaService.deletePizza(id);
	}
}
