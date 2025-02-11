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

import com.project.Service.AddressService;
import com.project.entites.Address;

@RestController
@RequestMapping("/addresses")
public class AddressController {

 @Autowired
  AddressService addressService;
	
    @PostMapping
     ResponseEntity<Address> createAddress(@RequestBody Address address){
    	  
    	 Address address2 = addressService.createAddress(address);
    	 
    	 return  new  ResponseEntity<>(address2,HttpStatus.CREATED);
      }
 
    @PutMapping("/{id}")
 
	 ResponseEntity<Address>updateAddress(@PathVariable Long id, @RequestBody  Address address ){
		 
		 Address address2 = addressService.createAddress(address);
		 
		 return new ResponseEntity<>(address2,HttpStatus.CREATED);
	 }
      
    @GetMapping("/{id}")
   ResponseEntity<Address> getById(@PathVariable Long id){
    	
	   Address byId = addressService.getById(id);
	   
	   return new ResponseEntity<>(byId,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
   ResponseEntity<String> delete(@PathVariable Long id){
	   
	   String deleteById = addressService.deleteById(id);
	   return new ResponseEntity<>(deleteById,HttpStatus.OK);
	   
	   
    }
   
   @GetMapping
  ResponseEntity<Page<Address>> getAll(
		  
		  @RequestParam(defaultValue = "0") int page,
		  @RequestParam(defaultValue = "20") int size
		  ){
	  
	   return ResponseEntity.ok(addressService.getAllAddress(PageRequest.of(page, size)));
   }
    
    
}
