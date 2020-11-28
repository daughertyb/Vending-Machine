package materials;

import java.math.BigDecimal;

public class Funds {

	private BigDecimal balance = new BigDecimal(0);

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal amountAdded) {
		this.balance = this.balance.add(amountAdded);
	}

	public void resetBalance(BigDecimal reset) {
		this.balance = reset;
	}

	public void deductBalance(BigDecimal deduct) {
		this.balance = this.balance.subtract(deduct);
	}

}
