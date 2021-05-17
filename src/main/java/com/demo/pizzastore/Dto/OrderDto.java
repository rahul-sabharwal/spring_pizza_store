package com.demo.pizzastore.Dto;

import java.util.ArrayList;
import java.util.List;

import com.demo.pizzastore.Domain.Pizza;
import com.demo.pizzastore.Domain.SideDish;

import lombok.Data;

@Data
public class OrderDto {

	private long id;
	private String customerName;
	private List<Pizza> pizza = new ArrayList<>();
	private List<SideDish> sideDish = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	public List<SideDish> getSideDish() {
		return sideDish;
	}
	public void setSideDish(List<SideDish> sideDish) {
		this.sideDish = sideDish;
	}

}
