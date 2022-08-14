package com.models;

public class Documents {
	String name;
	float Price;
	int rate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Documents(String name, float price, int rate) {
		super();
		this.name = name;
		Price = price;
		this.rate = rate;
	}

}
