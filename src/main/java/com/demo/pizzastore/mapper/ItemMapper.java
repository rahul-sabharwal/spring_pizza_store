package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Item;
import com.demo.pizzastore.domain.ItemType;
import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.dto.ItemDto;

@Component
public class ItemMapper {

	public ItemDto  toItemDto(SideDish sideDish) {
		ItemDto dto = new ItemDto();
		dto.setType(sideDish.getItemType().name());
		dto.setSdname(sideDish.getSdname());
		dto.setSdquantity(sideDish.getSdquantity());
		dto.setType(sideDish.getItemType().name());
		dto.setId(sideDish.getId());
		String desc = sideDish.getSdquantity() + " "+ sideDish.getSdname();
		dto.setDescription(desc);
		return dto;
	}
	
	public ItemDto  toItemDto(Pizza pizza) {
		ItemDto dto = new ItemDto();
		dto.setType(pizza.getItemType().name());
		dto.setPcrust(pizza.getCrust());
		dto.setPsize(pizza.getSize());
		dto.setPtoppings(pizza.getToppings());
		dto.setId(pizza.getId());
		String str = "A "+ pizza.getSize() +" pizza with "+ pizza.getCrust() +" crust "+ pizza.getToppings() +" topping(s).";
		dto.setDescription(str);
		return dto;
	}
	
	public List<ItemDto> toDto(List<SideDish> sideDish){
		return sideDish.stream().map(this::toItemDto).collect(Collectors.toList());
	}
	
	public List<ItemDto> toItemDto(List<Pizza> pizza){
		return pizza.stream().map(this::toItemDto).collect(Collectors.toList());
	}
	
	public Item toEntity(ItemDto dto) {
		if(dto.getType().equals("PIZZA")) {
			Pizza item = new Pizza();
			item.setId(dto.getId());
			item.setItemType(ItemType.valueOf(dto.getType()));
			item.setCrust(dto.getPcrust());
			item.setSize(dto.getPsize());
			item.setToppings(dto.getPtoppings());
			return item;
		} else {
			SideDish item = new SideDish();
			item.setId(dto.getId());
			item.setItemType(ItemType.valueOf(dto.getType()));
			item.setSdname(dto.getSdname());
			item.setSdquantity(dto.getSdquantity());
			return item;
		}
	}
}
