package com.web.customer.tracker.service;

import java.util.List;

import com.web.customer.tracker.entity.CustomerEntity;

public interface CustomerService {

	public List<CustomerEntity> getAllCustomers();
	public void addCustomer(CustomerEntity customer);
	public CustomerEntity getCustomerById(int id);
	public void deleteCustomerById(int id);
}
