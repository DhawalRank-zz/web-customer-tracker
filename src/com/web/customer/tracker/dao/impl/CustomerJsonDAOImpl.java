package com.web.customer.tracker.dao.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.web.customer.tracker.dao.CustomerJsonDAO;
import com.web.customer.tracker.pojo.Customer;


@Repository
public class CustomerJsonDAOImpl implements CustomerJsonDAO {
	private final Logger LOGGER = Logger.getLogger(CustomerJsonDAOImpl.class.getName());
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		LOGGER.info("Getting all customers...");
		List<Customer> customers = mongoTemplate.findAll(Customer.class);
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		LOGGER.info("Adding new customer...");
		mongoTemplate.insert(customer);
	}

	@Override
	public Customer getCustomerById(String id) {
		LOGGER.info("Getting customer with id: " + id);
		List<Customer> customers = getAllCustomers()
									.parallelStream()
									.filter(aCustomer -> aCustomer.getId().equals(id))
									.collect(Collectors.toList());
		if(customers.size() > 0) {
			return customers.get(0);
		}
		return new Customer();
	}

	@Override
	public int deleteCustomerById(String id) {
		Customer customer = getCustomerById(id);
		int result = 0;
		if(!customer.getId().equals(null)){
			mongoTemplate.remove(customer);
			result = 1;
		}
		return result;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		mongoTemplate.save(customer);
		return customer;
	}

}
