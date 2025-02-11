package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.Cart;

public interface CartService {

	   
      Cart createCart(Cart cart);
      
     Cart updateCart(Cart cart , Long id);
     
    Cart  getCartById(Long id);
     
    String  deleteById(Long id);
     
 Page<Cart> getAllCart(Pageable pageable);
}
