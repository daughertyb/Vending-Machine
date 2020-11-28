package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public abstract class Sellables {

	public String name;
	public BigDecimal price;
	public String slotLocation;
	public Integer quantity;
	public String type = "";
	public String noise;
	
	
	
	//Constructor
	public Sellables(String name, BigDecimal price, String slotLocation, Integer quantity, String type, String noise) {
		this.name = name;
		this.price = price;
		this.slotLocation = slotLocation;
		this.quantity = 5;
		this.type = type;
		this.noise = noise;
	}


	public String getName() {
		return name;
	}


	public BigDecimal getPrice() {
		return price;
	}



	public String getSlotLocation() {
		return slotLocation;
	}



	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		

	public String getType() {
		return type;
	}

	
	public String getNoise() {
		return noise;
	}

	
	
	
	
	
	
	
}
