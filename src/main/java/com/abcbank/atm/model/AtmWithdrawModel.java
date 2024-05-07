package com.abcbank.atm.model;

public class AtmWithdrawModel {

	private String atmName;

	private String atmBank;

	private String customerBankName;

	private String cardNumber;

	private String cardPin;

	private int withdrawAmount;

	public AtmWithdrawModel(String atmName, String atmBank, String customerBankName, String cardNumber, String cardPin,
			int withdrawAmount) {
		super();
		this.atmName = atmName;
		this.atmBank = atmBank;
		this.customerBankName = customerBankName;
		this.cardNumber = cardNumber;
		this.cardPin = cardPin;
		this.withdrawAmount = withdrawAmount;
	}

	public String getAtmBank() {
		return atmBank;
	}

	public void setAtmBank(String atmBank) {
		this.atmBank = atmBank;
	}

	public String getCustomerBankName() {
		return customerBankName;
	}

	public void setCustomerBankName(String customerBankName) {
		this.customerBankName = customerBankName;
	}

	public String getAtmName() {
		return atmName;
	}

	public void setAtmName(String atmName) {
		this.atmName = atmName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public int getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

}
