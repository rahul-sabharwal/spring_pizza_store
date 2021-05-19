package com.demo.pizzastore.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Order;
import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.dto.ItemDto;
import com.demo.pizzastore.dto.OrderDto;

@Component
public class OrderConverter {
	
	@Autowired
	private ItemMapper converter;
	
	public OrderDto toDto(Order order) {
		OrderDto dto = new OrderDto();
		List<ItemDto> sditemDto = converter.toDto(order.getSideDish());
		List<ItemDto> pitemDto = converter.toItemDto(order.getPizza());
		List<ItemDto> itemDto = Stream.concat(sditemDto.stream(), pitemDto.stream())
                .collect(Collectors.toList());
		dto.setId(order.getId());
		dto.setCustomerName(order.getCustomerName());
		dto.setItems(itemDto);
		return dto;
	}
	
	public List<OrderDto> toDto(List<Order> order){
		return order.stream().map(this::toDto).collect(Collectors.toList());
	}
	
	
	public Order toEntity(OrderDto dto) {
		Order order = new Order();
		order.setId(dto.getId());
		order.setCustomerName(dto.getCustomerName());
		List<Pizza> pizza = new ArrayList<Pizza>();
		List<SideDish> sideDish = new ArrayList<SideDish>();
		List<ItemDto> items = dto.getItems();
		for(ItemDto item : items) {
			if(item.getType().equals("PIZZA")) {
				pizza.add((Pizza) converter.toEntity(item));
			}else {
				sideDish.add( (SideDish) converter.toEntity(item));
			}
		}
		order.setPizza(pizza);
		order.setSideDish(sideDish);
		return order;
	}
}
