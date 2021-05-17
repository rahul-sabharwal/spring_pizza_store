package com.demo.pizzastore.dto;

import com.demo.pizzastore.domain.ItemType;

import lombok.Data;

@Data
public class ItemDto {
	
	private Long id;
	private ItemType type;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
}
