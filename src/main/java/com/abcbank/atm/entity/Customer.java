package com.abcbank.atm.entity;

//@Entity
public class Customer {

	private Long id;

	private String name;

	private Bank bank;

	private Account account;

	private Card card;

	public Customer(Long id, String name, Bank bank, Account account, Card card) {
		super();
		this.id = id;
		this.name = name;
		this.bank = bank;
		this.account = account;
		this.card = card;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}