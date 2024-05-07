package com.abcbank.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.atm.dao.AtmDao;
import com.abcbank.atm.dao.CustomerDao;
import com.abcbank.atm.entity.Atm;
import com.abcbank.atm.entity.Cash;
import com.abcbank.atm.entity.Customer;
import com.abcbank.atm.model.AtmWithdrawModel;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public String cashWithdraw(AtmWithdrawModel in) {

		if (!isValidCustomer(in)) {
			return "Invalid User & Pin";
		}

		if (!isSufficientBalanceExistInAccount(in)) {
			return "In sufficient balance in account";
		}

		return withdrawCash(in);
	}

	private String withdrawCash(AtmWithdrawModel in) {
		Atm atm = atmDao.findAtmByCustomerBankName(in.getAtmBank(), in.getAtmName());

		Cash temp = new Cash(atm.getCash());
		String msg = withdraw(atm, in.getWithdrawAmount());

		// update ATM balance & Customer balance
		if (msg.contains("Success")) {
			// update Customer account
		} else {
			// rollback
			atm.setCash(temp);
		}

		return msg;
	}

	public String withdraw(Atm atm, int wAmt) {
		// TODO Auto-generated method stub
		if (!hasSufficentCashInATM(atm, wAmt)) {
			return "ATM Machine not have sufficient cash...";
		}

		return withdrawWithMinimumBankNotes(atm.getCash(), wAmt) ? "Success" : "Give combination of 100s Notes";
	}

	private boolean withdrawWithMinimumBankNotes(Cash cash, int wAmt) {

		int n500 = wAmt / 500;
		if (n500 > 0) {
			if (cash.getNotes500() >= n500) {
				cash.setNotes500(cash.getNotes500() - n500);
				wAmt = wAmt - (500 * n500);
				System.err.println("500 -> " + n500);
			} else {

				wAmt = wAmt - (500 * cash.getNotes500());
				System.err.println("500 -> " + cash.getNotes500());
				cash.setNotes500(0);

			}
		}

		int n200 = wAmt / 200;
		if (n200 > 0) {
			if (cash.getNotes200() >= n200) {
				cash.setNotes200(cash.getNotes200() - n200);
				wAmt = wAmt - (200 * n200);
				System.err.println("200 -> " + n200);
			} else {

				wAmt = wAmt - (200 * cash.getNotes200());
				System.err.println("200 -> " + cash.getNotes200());
				cash.setNotes200(0);
			}
		}

		int n100 = wAmt / 100;
		if (n100 > 0) {
			if (cash.getNotes100() >= n100) {
				cash.setNotes100(cash.getNotes100() - n100);
				wAmt = wAmt - (100 * n100);
				System.err.println("100 -> " + n100);
			} else {
				wAmt = wAmt - (100 * cash.getNotes100());
				System.err.println("100 -> " + cash.getNotes100());
				cash.setNotes100(0);
			}
		}
		return wAmt == 0;
	}

	private boolean hasSufficentCashInATM(Atm atm, int wAmt) {
		return atm.getBalance() >= wAmt;
	}

	private boolean isSufficientBalanceExistInAccount(AtmWithdrawModel in) {
		Customer c = customerDao.findCustomerByCustomerBankName(in.getAtmBank(), in.getCardNumber());
		return c.getAccount().getAccountBalance() >= in.getWithdrawAmount();
	}

	private boolean isValidCustomer(AtmWithdrawModel in) {
		// Logic to validate Customer's Card with Bank

		// Logic to validate Customer's Pin
		return true;
	}
}
