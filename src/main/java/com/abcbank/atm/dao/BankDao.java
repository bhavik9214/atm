package com.abcbank.atm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.abcbank.atm.entity.Account;
import com.abcbank.atm.entity.Atm;
import com.abcbank.atm.entity.Bank;
import com.abcbank.atm.entity.Card;
import com.abcbank.atm.entity.Cash;
import com.abcbank.atm.entity.Customer;

@Repository
public class BankDao {
	
	private List<Bank> banks = new ArrayList<>();
	
	@PostConstruct
	public void buildDataSet() {
		Bank hdfcBank = new Bank(1L, "HDFC", new ArrayList<>(), new ArrayList<>());
		Bank sbiBank = new Bank(2L, "SBI", new ArrayList<>(), new ArrayList<>());

		hdfcBank.getAtms().add(new Atm(1L, "M1", "Mumbai", hdfcBank, new Cash(14, 12, 12)));
		hdfcBank.getAtms().add(new Atm(2L, "M2", "Pune", hdfcBank, new Cash(20, 10, 5)));

		sbiBank.getAtms().add(new Atm(3L, "M3", "Mumbai", sbiBank, new Cash(25, 15, 5)));

		hdfcBank.getCustomers().add(new Customer(1L, "Madhav", hdfcBank, new Account(1L, "123456", "Saving", 10000),
				new Card(1L, "Debit", "987654", "4567")));
		hdfcBank.getCustomers().add(new Customer(2L, "Ram", hdfcBank, new Account(2L, "456789", "Current", 12000),
				new Card(2L, "Credit", "1973484", "7894")));
		
		sbiBank.getCustomers().add(new Customer(3L, "Mahesh", sbiBank, new Account(3L, "7191747", "Current", 7000),
				new Card(2L, "Debit", "7413676", "7546")));
		
		banks.add(hdfcBank);
		banks.add(sbiBank);

		System.err.println("Data set prepared.....");
	}
	
	public Bank findBankByCustomerBankName(String bankName) {
		return banks.stream().filter(b -> b.getBankName().equals(bankName))
				.findFirst().get();
	}


}
