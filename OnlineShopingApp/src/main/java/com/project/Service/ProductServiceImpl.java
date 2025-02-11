package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.ProductNotFoundException;
import com.project.Repository.ProductRepository;
import com.project.entites.Product;

@Service
public class ProductServiceImpl  implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		
		Optional<Product> exsist = productRepo.findById(id);
		if(exsist.isPresent()) {
			Product product2 = exsist.get();
			
			product2.setName(product.getName());
			product2.setPrice(product.getPrice());
			product2.setCategory(product.getCategory());
			product2.setCart(product.getCart());
			product2.setOrder(product.getOrder());
			return productRepo.save(product);	
		}
		else {
			throw new ProductNotFoundException("Product is not found with id:"+id);
			
		}
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id)
				.orElseThrow(()-> new ProductNotFoundException("Product is not found with id:"+id));
		
	}

	@Override
	public String delete(Long id) {
	if(!productRepo.existsById(id)) {
		new ProductNotFoundException("Product is not found with id: "+id);
	}

		return "Product deleted successfully with id:"+id;
	}

	
	@Override
	public Page<Product> getAll(Pageable pageable) {
		
		return productRepo.findAll(pageable);
	}

}
