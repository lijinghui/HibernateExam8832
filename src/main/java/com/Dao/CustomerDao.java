package com.Dao;

import java.util.List;

import com.hand.model.Customer;

public interface CustomerDao {

	public void saveCus(Customer cus);
	
	public Customer getCus();
	
	public void delCus(Customer customer);
		
}
