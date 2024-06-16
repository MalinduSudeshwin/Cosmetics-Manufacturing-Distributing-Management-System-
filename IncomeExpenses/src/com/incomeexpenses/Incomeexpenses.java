package com.incomeexpenses;


public class Incomeexpenses {
	private int id;
	private String billID;
	private String category;
	private String date;
	private String phone;
	private String amount;
	


	public Incomeexpenses(int id,String billID, String category,String date, String phone, String amount) {
		this.id = id;
		this.billID = billID;
		this.category = category;
		this.date = date;
		this.phone = phone;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public String getBillID() {
		return billID;
	}
	

	public String getCategory() {
		return category;
	}

	public String getDate() {
		return date;
	}

	public String getPhone() {
		return phone;
	}

	public String getAmount() {
		return amount;
	}


}
