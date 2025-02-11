package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
