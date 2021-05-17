package com.demo.pizzastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.service.SideDishService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SideDishController {
	
	@Autowired
	private SideDishService sdService;
	
	//	get pizza
	@GetMapping("sidedish")
	public List<SideDish> getAllPizzas(){
		return sdService.getAllSideDishes();
	}
	
	@PostMapping("sidedish")
	public SideDish addSideDish(@RequestBody SideDish sideDish) {
		return sdService.addSideDish(sideDish);
	}
	
	@GetMapping("/sidedish/id={id}")
	public SideDish getSideDish(@PathVariable long id) {
		return sdService.getSideDish(id);
	}

	@PostMapping("/sidedish/update")
	public SideDish updateSideDish(@RequestBody SideDish sideDish) {
		return sdService.updateSideDish(sideDish);
	}
	
	@DeleteMapping("/sidedish/delete/id={id}")
	public void deleteSideDish(@PathVariable long id) {
		sdService.deleteSideDish(id);
	}
	
}
