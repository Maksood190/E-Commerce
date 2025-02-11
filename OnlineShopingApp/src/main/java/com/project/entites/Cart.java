package com.project.entites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cart {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    @JoinColumn(name = "customer_id")
	    @JsonBackReference
	    private Customer customer;

	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Product> products;
	    
	    
	    public Cart() {
			// TODO Auto-generated constructor stub
		}


		


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public List<Product> getProducts() {
			return products;
		}


		public void setProducts(List<Product> products) {
			this.products = products;
		}
	    
	    

		
	
}
