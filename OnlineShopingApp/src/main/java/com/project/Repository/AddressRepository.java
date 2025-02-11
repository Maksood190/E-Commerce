package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.Address;

public interface AddressRepository  extends JpaRepository<Address, Long>{

}
