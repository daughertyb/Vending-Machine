package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Chip extends Sellables {

	public Chip(String name, BigDecimal price, String slotLocation, String type, String noise) {
		super(name, price, slotLocation, 5, type, noise);

	}

}
