package com.web.customer.tracker.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.customer.tracker.dao.CustomerJsonDAO;
import com.web.customer.tracker.pojo.Customer;
import com.web.customer.tracker.service.CustomerJsonService;
import com.web.customer.tracker.util.HelperUtil;

@Service
public class CustomerJsonServiceImpl implements CustomerJsonService {
	
	@Autowired
	CustomerJsonDAO customerJsonDao;

	@Override
	public void addCustomer(Customer customer) {
		customerJsonDao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(String id) {
		return customerJsonDao.getCustomerById(id);
	}

	@Override
	public int deleteCustomerById(String id) {
		return customerJsonDao.deleteCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerJsonDao.getAllCustomers();

	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerJsonDao.updateCustomer(customer);
	}

	@Override
	public Map<List<Customer>, String> getCustomerByRole() {
		Map<String, List<Customer>> roleByCustomer = customerJsonDao
				.getAllCustomers()
				.stream()
				.collect(Collectors.groupingBy(Customer::getRole));
		return HelperUtil.reverse(roleByCustomer);
	}

}
