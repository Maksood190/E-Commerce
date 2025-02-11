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

import com.project.Service.CartService;
import com.project.entites.Cart;

@RestController
@RequestMapping("carts")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping
	ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		Cart cart2 = cartService.createCart(cart);
		
		return new ResponseEntity<Cart>(cart2,HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Cart> updateCart( @PathVariable Long id ,@RequestBody Cart cart) {
		Cart updateCart = cartService.updateCart(cart, id);
		return new ResponseEntity<Cart>(updateCart,HttpStatus.OK);

	}

	@GetMapping("/{id}")
	ResponseEntity<Cart> getById( @PathVariable Long id) {
		Cart cartById = cartService.getCartById(id);
		return new ResponseEntity<Cart>(cartById,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) {
		String deleteById = cartService.deleteById(id);
		
		return new ResponseEntity<String>(deleteById,HttpStatus.OK);
	}

	@GetMapping
    ResponseEntity<Page<Cart>>getAll(
		  
		  @RequestParam(defaultValue = "0") int page,
		  @RequestParam(defaultValue = "20") int size
		  ){
		
	  
	  return  ResponseEntity.ok(cartService.getAllCart(PageRequest.of(page, size)));
	}
	
}
