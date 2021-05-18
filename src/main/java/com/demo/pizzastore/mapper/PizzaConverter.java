package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.dto.PizzaDto;

@Component
public class PizzaConverter {
	
	public PizzaDto toDto(Pizza pizza) {
		ModelMapper mapper =new ModelMapper();
		PizzaDto dto = mapper.map(pizza, PizzaDto.class);
		return dto;
	}
	
	public List<PizzaDto> toDto(List<Pizza> pizza){
		return pizza.stream().map(this::toDto).collect(Collectors.toList());
	}
	
	public Pizza toEntity(PizzaDto dto) {
		ModelMapper mapper = new ModelMapper();
		Pizza order = mapper.map(dto, Pizza.class);
		return order;
	}
	
	public List<Pizza> toEntity(List<PizzaDto> dto){
		return dto.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
