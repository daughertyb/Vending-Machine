package com.techelevator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class DrinkTest {

	private Drink drinkTest;

	@Before
	public void setup() {

	}

	@Test
	public void name_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		drinkTest = new Drink("Mountain Melter", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");
		Assert.assertEquals("Mountain Melter", drinkTest.getName());

	}

	@Test
	public void sound_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		drinkTest = new Drink("Mountain Melter", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Munch Munch, Yum!", drinkTest.getNoise());

	}

	@Test
	public void slot_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		drinkTest = new Drink("Mountain Melter", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("B3", drinkTest.getSlotLocation());

	}

	@Test
	public void price_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		drinkTest = new Drink("Mountain Melter", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals(wonkaTest, drinkTest.getPrice());

	}

	@Test
	public void type_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		drinkTest = new Drink("Mountain Melter", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Candy", drinkTest.getType());

	}
}
