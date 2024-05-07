package com.abcbank.atm.entity;

public class Card {
	
	private Long Id;
	
	private String cardType;
	
	private String atmCardNumber; 	// Linked ATM card 
	
	private String atmCardPin;

	public Card(Long id, String cardType, String atmCardNumber, String atmCardPin) {
		super();
		Id = id;
		this.cardType = cardType;
		this.atmCardNumber = atmCardNumber;
		this.atmCardPin = atmCardPin;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAtmCardNumber() {
		return atmCardNumber;
	}

	public void setAtmCardNumber(String atmCardNumber) {
		this.atmCardNumber = atmCardNumber;
	}

	public String getAtmCardPin() {
		return atmCardPin;
	}

	public void setAtmCardPin(String atmCardPin) {
		this.atmCardPin = atmCardPin;
	}

}
