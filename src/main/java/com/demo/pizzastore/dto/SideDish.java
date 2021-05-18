package com.demo.pizzastore.dto;

import lombok.Data;

@Data
public class SideDish {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
