package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.SideDish;

@Component
public class SideDishConverter {

	
	public SideDish toDto(SideDish sideDish) {
		ModelMapper mapper =new ModelMapper();
		SideDish dto = mapper.map(sideDish, SideDish.class);
		return dto;
	}
	
	public List<SideDish> toDto(List<SideDish> pizza){
		return pizza.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
