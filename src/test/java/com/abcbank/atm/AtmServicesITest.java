package com.abcbank.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.abcbank.atm.entity.Atm;
import com.abcbank.atm.entity.Cash;
import com.abcbank.atm.model.AtmWithdrawModel;
import com.abcbank.atm.service.AtmServiceImpl;

public class AtmServicesITest extends AtmApplicationTests {

	@Autowired
	private AtmServiceImpl atmService;

	@Test
	public void testSignleCustomerCashWithdraw() {

		AtmWithdrawModel in = new AtmWithdrawModel("M1", "HDFC", "HDFC", "987654", "4567", 5000);
		assertEquals("Success", atmService.cashWithdraw(in));
	}

	@Test
	public void testMultipleCustomerCashWithdraw() {

		AtmWithdrawModel in = new AtmWithdrawModel("M1", "HDFC", "HDFC", "987654", "4567", 5000);
		AtmWithdrawModel in2 = new AtmWithdrawModel("M3", "SBI", "HDFC", "7413676", "7546", 200);
		assertEquals("Success", atmService.cashWithdraw(in));
		assertEquals("Success", atmService.cashWithdraw(in2));
	}
	
	@Test
	public void testInSufficientBalanceInCustomerAccount() {

		AtmWithdrawModel in = new AtmWithdrawModel("M1", "HDFC", "HDFC", "987654", "4567", 80000);
		assertEquals("In sufficient balance in account", atmService.cashWithdraw(in));
	}
	
	@Test
	public void testCombinationOf100NotesWithdrawAmount() {

		AtmWithdrawModel in = new AtmWithdrawModel("M1", "HDFC", "HDFC", "987654", "4567", 120);
		assertEquals("Give combination of 100s Notes", atmService.cashWithdraw(in));
	}

	@Test
	public void testWithdrawSuccessWithMinimum5And2HundredsNotes() {
		Atm atm = new Atm(new Cash(10, 7, 20));
		assertEquals("Success", atmService.withdraw(atm, 6000));
	}

	@Test
	public void testWithdrawSuccessWithMinimum5And2And1HundredsNotes() {
		Atm atm = new Atm(new Cash(10, 7, 20));
		assertEquals("Success", atmService.withdraw(atm, 5700));
	}

	@Test
	public void testWithdrawSuccessWithLimited5HundredsNotes() {
		Atm atm = new Atm(new Cash(8, 7, 20));
		assertEquals("Success", atmService.withdraw(atm, 5100));
	}

	@Test
	public void testWithdrawSuccessWithLimited5And2HundredsNotes() {
		Atm atm = new Atm(new Cash(2, 10, 34));
		assertEquals("Success", atmService.withdraw(atm, 5100));
	}

	@Test
	public void testATMMachineNotSufficientBalance() {
		Atm atm = new Atm(new Cash(2, 10, 34));
		assertEquals("ATM Machine not have sufficient cash...", atmService.withdraw(atm, 80000));
	}

	@Test
	public void testCustomerInputNotIn100Notes() {
		Atm atm = new Atm(new Cash(2, 10, 34));
		assertEquals("Give combination of 100s Notes", atmService.withdraw(atm, 220));
	}
}
