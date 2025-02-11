package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.CustomerNotFoundException;
import com.project.Repository.CustomerRepository;
import com.project.entites.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService {
	
	@Autowired
	 CustomerRepository customerRepo;
 
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {

		Optional<Customer> exsist = customerRepo.findById(id);
		if(exsist.isPresent()) {
			Customer customer2 = exsist.get();
			customer2.setEmail(customer.getEmail());
			customer2.setName(customer.getName());
			customer2.setPassword(customer.getPassword());
			customer2.setAddresses(customer.getAddresses());
			customer2.setCart(customer.getCart());
			
			return customerRepo.save(customer);
		}
		else {
			  throw new CustomerNotFoundException("Customer is not found with id:"+id);
		}
	
	}

	@Override
	public Customer getCustomerById(Long id) {

	return customerRepo.findById(id)
				.orElseThrow(()-> new CustomerNotFoundException("Customer not found with id:"+id));
		
		
	}

	@Override
	public String deleteCustomerByid(Long id) {
		if(!customerRepo.existsById(id)) {
			new CustomerNotFoundException("Customer is not found with id: "+id);
		}
		
		return "Customer sueccesfully deleted with id:"+id;
	}

	@Override
	public Page<Customer> getAllCustomer(Pageable pageable) {
		
		return customerRepo.findAll(pageable);
	}

	
	
}
