package com.demo.pizzastore.dto;

import lombok.Data;

@Data
public class ItemDto {
	
	
	private String item_description;


	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	
	
	
	
}
