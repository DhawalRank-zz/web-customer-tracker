package com.web.customer.tracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.customer.tracker.pojo.Customer;
import com.web.customer.tracker.service.CustomerJsonService;

@RestController
@RequestMapping("/api/customers")
public class CustomerApiController {

	@Autowired
	private CustomerJsonService customerJsonService;
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomerListInJson() {
		return ResponseEntity.ok(customerJsonService.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
		return ResponseEntity.ok(customerJsonService.getCustomerById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		if(customer.getFirstName().equals(null)
				|| customer.getLastName().equals(null)){
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.BAD_REQUEST);
		}
		customerJsonService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
		if(customer.getFirstName().equals(null)
				|| customer.getLastName().equals(null)){
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.BAD_REQUEST);
		}
		customer.setId(id);
		return new ResponseEntity<Customer>(customerJsonService.updateCustomer(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") String id) {
		int result = customerJsonService.deleteCustomerById(id);
		if(result != 1) {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	@GetMapping("/customersbyrole")
	public ResponseEntity<Map<List<Customer>, String>> customerByRole() {
		
		return new ResponseEntity<Map<List<Customer>,String>>(customerJsonService.getCustomerByRole(), HttpStatus.OK);
	}
}
