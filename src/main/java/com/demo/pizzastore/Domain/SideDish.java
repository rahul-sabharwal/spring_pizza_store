package com.demo.pizzastore.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="side_dish_table")
public class SideDish extends Item{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "sdid")
	public long id;
	
	@Column(name="sdname")
	public String sdname;
	
	@Column(name="sdquantity")
	public int sdquantity;
	
	public SideDish() {
		super(ItemType.SIDEDISH);
	}
	

	public SideDish(String sdname, int sdquantity) {
		super(ItemType.SIDEDISH);
		this.sdname = sdname;
		this.sdquantity = sdquantity;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSdname() {
		return sdname;
	}

	public void setSdname(String sdname) {
		this.sdname = sdname;
	}

	public int getSdquantity() {
		return sdquantity;
	}

	public void setSdquantity(int sdquantity) {
		this.sdquantity = sdquantity;
	}
	
	
	
}
