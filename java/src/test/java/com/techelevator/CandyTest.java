package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

	private Candy candyTest;

	@Before
	public void setup() {

	}

	@Test
	public void name_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		candyTest = new Candy("Wonka Bar", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");
		Assert.assertEquals("Wonka Bar", candyTest.getName());

	}

	@Test
	public void sound_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		candyTest = new Candy("Wonka Bar", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Munch Munch, Yum!", candyTest.getNoise());

	}

	@Test
	public void slot_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		candyTest = new Candy("Wonka Bar", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("B3", candyTest.getSlotLocation());

	}

	@Test
	public void price_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		candyTest = new Candy("Wonka Bar", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals(wonkaTest, candyTest.getPrice());

	}

	@Test
	public void type_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		candyTest = new Candy("Wonka Bar", wonkaTest, "B3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Candy", candyTest.getType());

	}

}
