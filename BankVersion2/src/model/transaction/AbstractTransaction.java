package model.transaction;

import model.Account;
import model.Money;

public abstract class AbstractTransaction implements Transaction {
	private static final long serialVersionUID = 1L;
	private Money amount;
	private Account account;
	private String text;

	public AbstractTransaction(Money amount, Account account, String text) {
		this.amount = amount;
		this.account = account;
		this.text = text;
	}

	public Money getAmount() {
		return amount;
	}

	public Account getAccount() {
		return account;
	}
	
	@Override
	public String getText() {
		return text;
	}
}