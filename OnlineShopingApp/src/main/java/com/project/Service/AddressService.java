package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.Address;

public interface AddressService {

	
	
     Address  createAddress(Address address);	
    
     Address  updateAddress(Long id, Address address);
 
     Address getById(Long id);
   
     String deleteById(Long id);
     
     Page<Address> getAllAddress(Pageable pageable);
	
}
