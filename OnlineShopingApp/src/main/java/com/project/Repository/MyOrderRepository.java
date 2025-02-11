package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.MyOrder;

public interface MyOrderRepository  extends JpaRepository<MyOrder, Long>{

}
