package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.dto.SideDishDto;

public class SideDishConverter {

	
	public SideDishDto entityToDto(SideDish sideDish) {
		ModelMapper mapper =new ModelMapper();
		SideDishDto dto = mapper.map(sideDish, SideDishDto.class);
		return dto;
	}
	
	public List<SideDishDto> entityToDto(List<SideDish> pizza){
		return pizza.stream().map(i->entityToDto(i)).collect(Collectors.toList());
	}
	
	public SideDish dtoToEntity(SideDishDto dto) {
		ModelMapper mapper = new ModelMapper();
		SideDish sd = mapper.map(dto, SideDish.class);
		return sd;
	}
	
	public List<SideDish> dtoToEntity(List<SideDishDto> dto){
		return dto.stream().map(i->dtoToEntity(i)).collect(Collectors.toList());
	}
}
