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

import com.project.Service.ProductService;
import com.project.entites.Product;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping
	 ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product2 = productService.createProduct(product);
		
		return  new ResponseEntity<Product>(product2,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
     ResponseEntity<Product>updatePrduct(@PathVariable Long id ,@RequestBody Product product){
	 Product updateProduct = productService.updateProduct(id, product);
	   
		return new ResponseEntity<Product>(updateProduct,HttpStatus.OK);
		
	}
     
     @GetMapping("/{id}")
     ResponseEntity<Product>getById(@PathVariable Long id){
	  Product productById = productService.getProductById(id);
	  
	return new ResponseEntity<Product>(productById,HttpStatus.OK);
	  
	}
     
     @DeleteMapping("/{id}")
     ResponseEntity<String> delete(@PathVariable Long id){
	 String delete = productService.delete(id);
	 return new ResponseEntity<String>(delete,HttpStatus.OK);
	}
	
      @GetMapping()
         ResponseEntity<Page<Product>>	getAll(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "20") int size
		){
		
	return ResponseEntity.ok(productService.getAll(PageRequest.of(page, size)));
	}
	
}
