package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.CartNotFoundException;
import com.project.Repository.CartRepository;
import com.project.entites.Cart;


@Service
public class CartServiceImpl  implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public Cart createCart(Cart cart) {
		
		return cartRepo.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart, Long id) {

		Optional<Cart> exsist = cartRepo.findById(id);
		if(exsist.isPresent()) {
			Cart cart2 = exsist.get();
			cart2.setCustomer(cart.getCustomer());
			cart2.setProducts(cart.getProducts());
		return 	cartRepo.save(cart);
			
		}
		else {
			 throw new CartNotFoundException("Cart is not found with id:"+id);	
		}
	}

	@Override
	public Cart getCartById(Long id) {

		return cartRepo.findById(id)
				
		.orElseThrow(()-> new CartNotFoundException("Cart is not found with id:"+id));


	}

	@Override
	public String deleteById(Long id) {

		if(!cartRepo.existsById(id)){
			
			new   CartNotFoundException("Care is not found with id: "+id);
		}
		return "Cart is sueccfully deleted with id:"+id;
	}

	@Override
	public Page<Cart> getAllCart(Pageable pageable) {
		
		return cartRepo.findAll(pageable);
	}

}
