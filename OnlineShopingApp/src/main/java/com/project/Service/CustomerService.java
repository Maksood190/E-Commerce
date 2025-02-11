package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.Customer;

public interface CustomerService {

	
	Customer createCustomer(Customer customer);
	
    Customer updateCustomer(Customer customer, Long id);
	
	Customer getCustomerById(Long id);
	
    String  deleteCustomerByid(Long id);
	
   Page<Customer>	getAllCustomer(Pageable pageable);
	
	
	
	
	
	
}
