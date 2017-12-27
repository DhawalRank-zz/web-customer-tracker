package com.web.customer.tracker.dao;

import java.util.List;

import com.web.customer.tracker.entity.CustomerEntity;

public interface CustomerDAO {

	public List<CustomerEntity> getAllCustomers();
	public void addCustomer(CustomerEntity customer);
	public CustomerEntity getCustomerById(int id);
	public void deleteCustomerById(int id);
}
