package com.abcbank.atm.entity;

public class Atm {

	private Long id;

	private String atmName;

	private String atmLocation;

	private Bank bank;

	private Cash cash;

	public Atm(Cash cash) {
		super();
		this.cash = cash;
	}

	public Atm(Long id, String atmName, String atmLocation, Bank bank, Cash cash) {
		super();
		this.id = id;
		this.atmName = atmName;
		this.atmLocation = atmLocation;
		this.bank = bank;
		this.cash = cash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtmName() {
		return atmName;
	}

	public void setAtmName(String atmName) {
		this.atmName = atmName;
	}

	public String getAtmLocation() {
		return atmLocation;
	}

	public void setAtmLocation(String atmLocation) {
		this.atmLocation = atmLocation;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	public int getBalance() {
		return (500 * cash.getNotes500()) + (200 * cash.getNotes200()) + (100 * cash.getNotes100());
	}

}