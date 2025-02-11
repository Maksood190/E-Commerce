package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.Cart;

public interface CartRepository  extends JpaRepository<Cart, Long>{

}
