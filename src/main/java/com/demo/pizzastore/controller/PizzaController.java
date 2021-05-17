package com.demo.pizzastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.dto.PizzaDto;
import com.demo.pizzastore.mapper.PizzaConverter;
import com.demo.pizzastore.service.PizzaService;

@RestController(value = "/api/v1/pizza")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private PizzaConverter converter;
	
	//	get pizza
	@GetMapping()
	public List<PizzaDto> getAllPizzas(@RequestParam String crustType){
		return converter.entityToDto(pizzaService.getAllPizza());
	}
	
	@PostMapping()
	public PizzaDto addPizza(@RequestBody PizzaDto dto) {
		Pizza pizza = converter.dtoToEntity(dto);
		pizza = pizzaService.addPizza(pizza);
		return converter.entityToDto(pizzaService.addPizza(pizza)); 
	}
	
	@GetMapping("/{id}")
	public PizzaDto getPizza(@PathVariable long id) {
		return converter.entityToDto(pizzaService.getPizza(id));
	}
//
	@PostMapping("/update")
	public PizzaDto updateSideDish(@RequestBody Pizza pizza) {
		return converter.entityToDto(pizzaService.updatePizza(pizza));
	}
	
	@DeleteMapping("/{id}")
	public void deleteSideDish(@PathVariable long id) {
		pizzaService.deletePizza(id);
	}
}
