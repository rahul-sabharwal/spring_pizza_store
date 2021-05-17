package com.demo.pizzastore.dto;

import lombok.Data;

@Data
public class PizzaDto {
	
	private String crustType;
	private String size;
	private String toppings;
	public String getCrustType() {
		return crustType;
	}
	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getToppings() {
		return toppings;
	}
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
	
	
	
}
