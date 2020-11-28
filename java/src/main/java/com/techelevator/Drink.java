package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Sellables {

	public Drink(String name, BigDecimal price, String slotLocation, String type, String noise) {
		super(name, price, slotLocation, 5, type, noise);

	}

}
