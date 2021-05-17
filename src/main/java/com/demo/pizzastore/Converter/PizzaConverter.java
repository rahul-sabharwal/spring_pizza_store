package com.demo.pizzastore.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.Domain.Pizza;
import com.demo.pizzastore.Dto.PizzaDto;

@Component
public class PizzaConverter {
	
	public PizzaDto entityToDto(Pizza pizza) {
		ModelMapper mapper =new ModelMapper();
		PizzaDto dto = mapper.map(pizza, PizzaDto.class);
		return dto;
	}
	
	public List<PizzaDto> entityToDto(List<Pizza> pizza){
		return pizza.stream().map(i->entityToDto(i)).collect(Collectors.toList());
	}
	
	public Pizza dtoToEntity(PizzaDto dto) {
		ModelMapper mapper = new ModelMapper();
		Pizza order = mapper.map(dto, Pizza.class);
		return order;
	}
	
	public List<Pizza> dtoToEntity(List<PizzaDto> dto){
		return dto.stream().map(i->dtoToEntity(i)).collect(Collectors.toList());
	}
}
