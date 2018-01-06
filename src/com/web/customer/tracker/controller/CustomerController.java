package com.web.customer.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.customer.tracker.pojo.Customer;
import com.web.customer.tracker.service.CustomerJsonService;
import com.web.customer.tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerJsonService customerJsonService;
	
	@GetMapping("/list") 
	public String getAllCustomers(Model aModel) {
		aModel.addAttribute("customers", customerJsonService.getAllCustomers());
		return "list-customers";
	}
	
	@GetMapping("/addCustomerForm")
	public String addCustomerForm(Model aModel) {
		aModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerJsonService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomerForm")
	public String updateCustomerForm(@RequestParam("customerId") String id, Model aModel){
		Customer customer = customerJsonService.getCustomerById(id);
		aModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customer/list";
	}
}
