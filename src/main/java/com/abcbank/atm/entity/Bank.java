package com.abcbank.atm.entity;

import java.util.List;

public class Bank {
	
	private Long bankId;
	
	private String bankName;

	private List<Customer> customers;
	
	private List<Atm> atms;

	public Bank(Long bankId, String bankName, List<Customer> customers, List<Atm> atms) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.customers = customers;
		this.atms = atms;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Atm> getAtms() {
		return atms;
	}

	public void setAtms(List<Atm> atms) {
		this.atms = atms;
	}
}
