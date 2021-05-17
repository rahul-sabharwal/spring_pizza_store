package com.demo.pizzastore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.pizzastore.domain.Order;
import com.demo.pizzastore.dto.OrderDto;

@Component
public class OrderConverter {
	
//	public OrderDto entityToDto(Order order) {
//		ModelMapper mapper =new ModelMapper();
//		OrderDto dto = mapper.map(order, OrderDto.class);
//		return dto;
//	}
	
//	public List<OrderDto> entityToDto(List<Order> order){
//		return order.stream().map(i->entityToDto(i)).collect(Collectors.toList());
//	}
//	
//	public Order dtoToEntity(OrderDto dto) {
//		ModelMapper mapper = new ModelMapper();
//		Order order = mapper.map(dto, Order.class);
//		return order;
//	}
//	
//	public List<Order> dtoToEntity(List<OrderDto> order){
//		return order.stream().map(i->dtoToEntity(i)).collect(Collectors.toList());
//	}
	
	public OrderDto toDto(Order order){
		OrderDto dto = new OrderDto();
		dto.setId(order.getId());
		dto.setCustomerName(order.getCustomerName());
	}
}
