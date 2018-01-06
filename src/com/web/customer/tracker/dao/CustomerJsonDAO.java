package com.web.customer.tracker.dao;

import java.util.List;


import com.web.customer.tracker.pojo.Customer;

public interface CustomerJsonDAO{
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public Customer getCustomerById(String id);
	public Customer updateCustomer(Customer customer);
	public int deleteCustomerById(String id);
}
