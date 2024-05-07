package com.abcbank.atm.entity;

public class Cash {

	private int notes500;
	
	private int notes200;
	
	private int notes100;
	
	
	
	public Cash(Cash cash) {
		super();
		this.notes500 = cash.notes500;
		this.notes200 = cash.notes200;
		this.notes100 = cash.notes100;
	}

	public Cash(int notes500, int notes200, int notes100) {
		super();
		this.notes500 = notes500;
		this.notes200 = notes200;
		this.notes100 = notes100;
	}

	public int getNotes500() {
		return notes500;
	}

	public void setNotes500(int notes500) {
		this.notes500 = notes500;
	}

	public int getNotes200() {
		return notes200;
	}

	public void setNotes200(int notes200) {
		this.notes200 = notes200;
	}

	public int getNotes100() {
		return notes100;
	}

	public void setNotes100(int notes100) {
		this.notes100 = notes100;
	}
	
}
