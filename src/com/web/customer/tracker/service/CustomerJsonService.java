package com.web.customer.tracker.service;

import java.util.List;
import java.util.Map;

import com.web.customer.tracker.pojo.Customer;

public interface CustomerJsonService {
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public Customer getCustomerById(String id);
	public int deleteCustomerById(String id);
	public Customer updateCustomer(Customer customer);
	public Map<List<Customer>, String> getCustomerByRole(); 
}
