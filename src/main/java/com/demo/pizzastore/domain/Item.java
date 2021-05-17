package com.demo.pizzastore.domain;

public abstract class Item {
	
	private ItemType itemType;
	
	protected Item() {}
	
	protected Item(ItemType type){
	    this.itemType = type;
	 }
	
	public ItemType getItemType() {
		return itemType;
	}
	
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public abstract long getId();
	
	public abstract void setId(long id);
	
	
}
