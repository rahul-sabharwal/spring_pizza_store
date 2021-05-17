package com.demo.pizzastore.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
	private long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pizza_fk", referencedColumnName = "id")
	List<Pizza> pizza = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="sd_fk", referencedColumnName = "id")
	List<SideDish> sideDish = new ArrayList<>();
	
	
	public Order() {
		
	}

	public Order(String customerName) {
		super();
		this.customerName = customerName;
	}

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
