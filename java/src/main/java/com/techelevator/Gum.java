package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Sellables {

	public Gum(String name, BigDecimal price, String slotLocation, String type, String noise) {
		super(name, price, slotLocation, 5, type, noise);
	}

}
