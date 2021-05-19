package com.demo.pizzastore.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ItemDto {
	
	private long id;
	private String type;
	private String description;
	
    @JsonIgnore
	private String sdname;
    
    @JsonIgnore
	private int sdquantity;
    
    @JsonIgnore
    private String psize;
    
    @JsonIgnore
	private String pcrust;
    
    @JsonIgnore
	private String ptoppings;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public String getPcrust() {
		return pcrust;
	}
	public void setPcrust(String pcrust) {
		this.pcrust = pcrust;
	}
	public String getPtoppings() {
		return ptoppings;
	}
	public void setPtoppings(String ptoppings) {
		this.ptoppings = ptoppings;
	}
	
	
}
