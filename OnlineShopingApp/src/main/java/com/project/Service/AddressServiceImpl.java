package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.AddressNotFoundException;
import com.project.Repository.AddressRepository;
import com.project.entites.Address;


@Service
public class AddressServiceImpl  implements AddressService{

	@Autowired
	AddressRepository addressRepo;
	
	
	@Override
	public Address createAddress(Address address) {
		
		return addressRepo.save(address);
	}

	@Override
	public Address updateAddress(Long id, Address address) {

		Optional<Address> byId = addressRepo.findById(id);
		   if(byId.isPresent()) {
			   Address address2 = byId.get();
			   address2.setStreet(address.getStreet());
			   address2.setCity(address.getCity());
			   address2.setState(address.getState());
			   address2.setZipCode(address.getZipCode());
			   
			  return  addressRepo.save(address);
		   }
		   else {
			  throw new AddressNotFoundException("Address is not found with id:"+id);
			   
		   }
	
	}

	@Override
	public Address getById(Long id) {

	return	addressRepo.findById(id)
				.orElseThrow(()-> new AddressNotFoundException("Address is not found with id:"+id));
		
	}

	@Override
	public String deleteById(Long id) {
		if(!addressRepo.existsById(id)){
			 new AddressNotFoundException("Address is not found with id: "+id);
		}
                
		return "Address is successfully deleted with id:"+id;
	}

	@Override
	public Page<Address> getAllAddress(Pageable pageable) {
		
		return addressRepo.findAll(pageable);
	}

	

}
