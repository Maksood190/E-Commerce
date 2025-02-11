package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.MyOrder;

public interface MyOrderService {

	
MyOrder	createOrder(MyOrder order);
MyOrder	updateOrder(MyOrder order, Long id);
MyOrder	getOrderById(Long id);
String	delete(Long id);
Page<MyOrder>	getAllOrder(Pageable pageable);
	
	
}
