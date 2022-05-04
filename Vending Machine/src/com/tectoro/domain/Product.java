package com.tectoro.domain;

public enum Product {
	
	TWIX(1,100), COKE(2,50), WATER(3,30), SANDWICH(4,150), EMPTY(0,0);
	
	private int id;
    private int price;
    
	Product(int id, int price) {
		this.id = id;
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
