package com.techelevator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class ChipTest {

	private Chip chipTest;

	@Before
	public void setup() {

	}

	@Test
	public void name_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		chipTest = new Chip("Potato Crisps", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");
		Assert.assertEquals("Potato Crisps", chipTest.getName());

	}

	@Test
	public void sound_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		chipTest = new Chip("Potato Crisps", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Munch Munch, Yum!", chipTest.getNoise());

	}

	@Test
	public void slot_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		chipTest = new Chip("Potato Crisps", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("D3", chipTest.getSlotLocation());

	}

	@Test
	public void price_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		chipTest = new Chip("Potato Crisps", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals(wonkaTest, chipTest.getPrice());

	}

	@Test
	public void type_return_test() {
		BigDecimal wonkaTest = new BigDecimal(1.50);
		chipTest = new Chip("Potato Crisps", wonkaTest, "D3", "Candy", "Munch Munch, Yum!");

		Assert.assertEquals("Candy", chipTest.getType());

	}
}
