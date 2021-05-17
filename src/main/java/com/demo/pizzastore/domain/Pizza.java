package com.demo.pizzastore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pizza_table")
public class Pizza extends Item {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private long id;
    
    @Column(name="crust")
	private String crustType;
	
	@Column(name="size")
	private String size;
	
	@Column(name="toppings")
	private String toppings;
	
	
	public Pizza() {
		super(ItemType.PIZZA);
	}
	
	public Pizza(String crustType, String size, String toppings) {
		super(ItemType.PIZZA);
		this.crustType = crustType;
		this.size = size;
		this.toppings = toppings;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getCrust() {
		return crustType;
	}

	public void setCrust(String crustType) {
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
