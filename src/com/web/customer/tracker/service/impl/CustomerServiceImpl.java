package com.web.customer.tracker.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.customer.tracker.dao.CustomerDAO;
import com.web.customer.tracker.entity.CustomerEntity;
import com.web.customer.tracker.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<CustomerEntity> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}
	
	@Transactional
	@Override
	public void addCustomer(CustomerEntity customer) {
		customerDAO.addCustomer(customer);
	}

	@Transactional
	@Override
	public CustomerEntity getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}

	@Transactional
	@Override
	public void deleteCustomerById(int id) {
		customerDAO.deleteCustomerById(id);
	}
}
