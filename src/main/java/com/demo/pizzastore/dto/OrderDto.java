package com.demo.pizzastore.dto;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;

@Data
public class OrderDto {

	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String customerName;
	private List<ItemDto> items = new ArrayList<>();

	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<ItemDto> getItems() {
		return items;
	}
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
}
