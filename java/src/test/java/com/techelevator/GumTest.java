package com.techelevator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class GumTest {

	private Gum gumTest;

	@Before
	public void setup() {

	}

	@Test
	public void name_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		gumTest = new Gum("Mountain Melter", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");
		Assert.assertEquals("Mountain Melter", gumTest.getName());

	}

	@Test
	public void sound_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		gumTest = new Gum("Mountain Melter", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Munch Munch, Yum!", gumTest.getNoise());

	}

	@Test
	public void slot_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		gumTest = new Gum("Mountain Melter", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("D3", gumTest.getSlotLocation());

	}

	@Test
	public void price_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		gumTest = new Gum("Mountain Melter", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals(wonkaTest, gumTest.getPrice());

	}

	@Test
	public void type_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		gumTest = new Gum("Mountain Melter", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Candy", gumTest.getType());

	}
}
