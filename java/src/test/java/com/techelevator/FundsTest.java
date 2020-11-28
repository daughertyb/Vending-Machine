package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import materials.Funds;

public class FundsTest {

	@Test
	public void set_balance_test() {
		BigDecimal amountAdded = new BigDecimal(1.50);
		Funds setBalanceTest = new Funds();
		setBalanceTest.setBalance(amountAdded);
		Assert.assertEquals(amountAdded, setBalanceTest.getBalance());
	}

	@Test
	public void reset_balance_test() {
		BigDecimal amountReset = new BigDecimal(10000.50);
		Funds resetBalanceTest = new Funds();
		resetBalanceTest.resetBalance(amountReset);
		Assert.assertEquals(amountReset, resetBalanceTest.getBalance());
	}

	@Test
	public void deduct_balance_test() {
		BigDecimal amountDeducted = new BigDecimal(2.00);
		BigDecimal expectedResult = new BigDecimal(-2.00);
		Funds deductBalanceTest = new Funds();
		deductBalanceTest.deductBalance(amountDeducted);
		Assert.assertEquals(expectedResult, deductBalanceTest.getBalance());
	}

}
