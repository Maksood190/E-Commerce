package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.Product;

public interface ProductService {

	
	Product     createProduct(Product product);
	Product 	updateProduct(Long id,Product product);
	Product 	getProductById(Long id);
     String	    delete(Long id);


 Page<Product>   getAll(Pageable pageable);
}
