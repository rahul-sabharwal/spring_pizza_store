package com.demo.pizzastore.dto;

import lombok.Data;

@Data
public class SideDishDto {
	private String sdname;
	private int sdquantity;
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
