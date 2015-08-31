package com.Dao;

import java.util.List;

import com.hand.model.Customer;

public interface CustomerDao {

	public int saveCus(Customer cus);
	
	public Customer getCus(int id);
	
	public void delCus(Short id);
		
}
