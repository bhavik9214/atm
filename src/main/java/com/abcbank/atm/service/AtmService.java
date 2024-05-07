package com.abcbank.atm.service;

import com.abcbank.atm.entity.Atm;
import com.abcbank.atm.model.AtmWithdrawModel;

public interface AtmService {

	public String cashWithdraw(AtmWithdrawModel in);
	
	public String withdraw(Atm atm, int wAmt);

}
