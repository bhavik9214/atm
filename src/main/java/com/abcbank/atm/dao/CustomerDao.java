package com.abcbank.atm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcbank.atm.entity.Bank;
import com.abcbank.atm.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private BankDao bankDao;

	public Customer findCustomerByCustomerBankName(String bankName, String cardNumber) {
		Bank bank = bankDao.findBankByCustomerBankName(bankName);
		return bank.getCustomers().stream().filter(b -> b.getCard().getAtmCardNumber().equals(cardNumber))
				.findFirst().get();
	}
	
}
