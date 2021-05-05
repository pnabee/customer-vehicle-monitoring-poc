package com.cust.vehicle.monitor.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cust.vehicle.monitor.model.Customer;
import com.cust.vehicle.monitor.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api(value = "Customer API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Save customer")
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@ApiOperation(value = "Get all customers")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> customers = customerService.findAll();
		if (customers.isEmpty()) {
			return noContent().build();
		}
		return ok(customers);
	}

	@ApiOperation(value = "Get customer by customerid")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> findById(
			@PathVariable("customerId") Long customerId) {
		return customerService.find(customerId).map(ResponseEntity::ok)
				.orElse(notFound().build());
	}

}