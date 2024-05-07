package com.abcbank.atm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcbank.atm.entity.Atm;
import com.abcbank.atm.entity.Bank;

@Repository
public class AtmDao {
	
	@Autowired
	private BankDao bankDao;

	public Atm findAtmByCustomerBankName(String bankName, String atmName) {
		Bank bank = bankDao.findBankByCustomerBankName(bankName);
		return bank.getAtms().stream().filter(b -> b.getAtmName().equals(atmName))
				.findFirst().get();
	}

	public void save(Atm atm) {
		// save logic
	}
	
}
