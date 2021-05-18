package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.dto.ItemDto;

@Component
public class ItemMapper {

	public ItemDto  toItemDto(SideDish sideDish) {
		ItemDto dto = new ItemDto();
		String desc = sideDish.getItemType().name()+":"
				+sideDish.getSdname()+":"+sideDish.getSdquantity();
		dto.setItem_description(desc);
		return dto;
	}
	
	public ItemDto  toItemDto(Pizza pizza) {
		ItemDto dto = new ItemDto();
		String desc = pizza.getItemType().name()+":"
				+pizza.getCrust()+":"+pizza.getSize()+":"+pizza.getToppings();
		dto.setItem_description(desc);
		return dto;
	}
	
	public List<ItemDto> toDto(List<SideDish> sideDish){
		return sideDish.stream().map(this::toItemDto).collect(Collectors.toList());
	}
	
	public List<ItemDto> toItemDto(List<Pizza> pizza){
		return pizza.stream().map(this::toItemDto).collect(Collectors.toList());
	}
}
