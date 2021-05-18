package com.demo.pizzastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.dto.PizzaDto;
import com.demo.pizzastore.mapper.PizzaConverter;
import com.demo.pizzastore.service.PizzaService;

@RestController
@RequestMapping("/api/v1/pizza")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private PizzaConverter converter;
	
	//	get pizza
	@GetMapping("/all")
	public List<PizzaDto> getAllPizzas(@RequestParam String crustType){
		return converter.toDto(pizzaService.getAllPizza());
	}
	
	@PostMapping()
	public PizzaDto addPizza(@RequestBody PizzaDto dto) {
		Pizza pizza = converter.toEntity(dto);
		pizza = pizzaService.addPizza(pizza);
		return converter.toDto(pizzaService.addPizza(pizza)); 
	}
	
	@GetMapping("/{id}")
	public PizzaDto getPizza(@PathVariable long id) {
		return converter.toDto(pizzaService.getPizza(id));
	}
//
	@PostMapping("/update")
	public PizzaDto updatePizza(@RequestBody Pizza pizza) {
		return converter.toDto(pizzaService.updatePizza(pizza));
	}
	
	@DeleteMapping("/{id}")
	public void deletePizza(@PathVariable long id) {
		pizzaService.deletePizza(id);
	}
}
