package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
