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
		dto.setType(sideDish.getItemType().name());
		dto.setId(sideDish.getId());
		String desc = sideDish.getSdquantity() + " "+ sideDish.getSdname();
		dto.setDescription(desc);
		return dto;
	}
	
	public ItemDto  toItemDto(Pizza pizza) {
		ItemDto dto = new ItemDto();
		dto.setType(pizza.getItemType().name());
		dto.setId(pizza.getId());
		String desc = "A "+pizza.getSize()+" Pizza with " + pizza.getCrust() + " crust and "+ pizza.getToppings() + " topping(s).";
		dto.setDescription(desc);
		return dto;
	}
	
	public List<ItemDto> toDto(List<SideDish> sideDish){
		return sideDish.stream().map(this::toItemDto).collect(Collectors.toList());
	}
	
	public List<ItemDto> toItemDto(List<Pizza> pizza){
		return pizza.stream().map(this::toItemDto).collect(Collectors.toList());
	}
}
