package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.CustomerService;
import com.project.entites.Customer;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping
    ResponseEntity<Customer>createCustomer(@RequestBody Customer customer){
	Customer customer2 = customerService.createCustomer(customer);
	
	return new ResponseEntity<>(customer2,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
		  
	 Customer updateCustomer = customerService.updateCustomer(customer, id);
	 
	 return new ResponseEntity<>(updateCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    ResponseEntity<Customer>getById(@PathVariable Long id){
	Customer customerById = customerService.getCustomerById(id);	
	
          return new ResponseEntity<>(customerById,HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
ResponseEntity<String>delete(@PathVariable Long id){
	String deleteCustomerByid = customerService.deleteCustomerByid(id);	
	
	
	return new ResponseEntity<>(deleteCustomerByid,HttpStatus.OK);
	}
	
	@GetMapping
   ResponseEntity<Page<Customer>>getAll(
		   
		   @RequestParam(defaultValue ="0")  int page,
		   @RequestParam(defaultValue = "20") int size
		   ){
		
		   return  ResponseEntity.ok(customerService.getAllCustomer(PageRequest.of(page, size)));
	
	}
	
}
