package com.cust.vehicle.monitor.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.vehicle.monitor.model.Customer;
import com.cust.vehicle.monitor.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> find(Long customerId) {

		if (null == customerId) {
			throw new IllegalArgumentException("customerId is missing");
		}

		return customerRepository.findById(customerId);
	}
	
	public Optional<Customer> findCustomerByName(String name){
		return customerRepository.findCustomerByName(name);
		
	}

}
