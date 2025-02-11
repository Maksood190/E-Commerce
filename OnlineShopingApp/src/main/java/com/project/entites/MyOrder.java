package com.project.entites;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class MyOrder {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private LocalDateTime orderDate;

	    @ManyToOne 
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	    private List<Product> products;

	    
	    
	    public MyOrder() {
			// TODO Auto-generated constructor stub
		}



		public MyOrder(Long id, LocalDateTime orderDate, Customer customer) {
			super();
			this.id = id;
			this.orderDate = orderDate;
			this.customer = customer;
			
			
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public LocalDateTime getOrderDate() {
			return orderDate;
		}



		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
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
