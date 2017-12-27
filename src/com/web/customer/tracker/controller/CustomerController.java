package com.web.customer.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.customer.tracker.entity.CustomerEntity;
import com.web.customer.tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list") 
	public String getAllCustomers(Model aModel) {
		aModel.addAttribute("customers", customerService.getAllCustomers());
		return "list-customers";
	}
	
	@GetMapping("/addCustomerForm")
	public String addCustomerForm(Model aModel) {
		aModel.addAttribute("customer", new CustomerEntity());
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") CustomerEntity customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomerForm")
	public String updateCustomerForm(@RequestParam("customerId") int id, Model aModel){
		CustomerEntity customer = customerService.getCustomerById(id);
		aModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customer/list";
	}
}
