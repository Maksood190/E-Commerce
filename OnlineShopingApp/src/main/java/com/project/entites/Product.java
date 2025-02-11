package com.project.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Product {

	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private Double price;

	    @Enumerated(EnumType.STRING)
	    private CategoryEnum category;

	    @ManyToOne
	    @JoinColumn(name = "cart_id")
	    @JsonIgnore  // This prevents circular reference
	    private Cart cart;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private MyOrder order;

	    
	    public Product() {
			// TODO Auto-generated constructor stub
		}


		public Product(Long id, String name, Double price, CategoryEnum category, Cart cart, MyOrder order) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.category = category;
			this.cart = cart;
			this.order = order;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public CategoryEnum getCategory() {
			return category;
		}


		public void setCategory(CategoryEnum category) {
			this.category = category;
		}


		public Cart getCart() {
			return cart;
		}


		public void setCart(Cart cart) {
			this.cart = cart;
		}


		public MyOrder getOrder() {
			return order;
		}


		public void setOrder(MyOrder order) {
			this.order = order;
		}
	    
	    
	    
	   
	}
	
	
	
	
	

