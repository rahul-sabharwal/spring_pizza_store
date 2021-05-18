package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Order;
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
		dto.setCustomerName(order.getCustomerName());
		dto.setItems(itemDto);
		return dto;
	}
	
	public List<OrderDto> toDto(List<Order> order){
		return order.stream().map(this::toDto).collect(Collectors.toList());
	}
	
	
}
