package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.MyOrderNotFoundException;
import com.project.Repository.MyOrderRepository;
import com.project.entites.MyOrder;

@Service
public class MyOrderServiceImpl  implements MyOrderService{

	@Autowired
	MyOrderRepository myOrderRepo;
	
	@Override
	public MyOrder createOrder(MyOrder order) {
		
		return myOrderRepo.save(order);
	}

	@Override
	public MyOrder updateOrder(MyOrder order, Long id) {
		
		Optional<MyOrder> exsist = myOrderRepo.findById(id);
		if(exsist.isPresent()) {
			MyOrder myOrder = exsist.get();
			myOrder.setCustomer(order.getCustomer());
			myOrder.setProducts(order.getProducts());
			myOrder.setOrderDate(order.getOrderDate());
		return myOrderRepo.save(order);
		}
		else {
			
			throw new MyOrderNotFoundException("Order is not found with id:"+id);
		}
		
		
	}

	@Override
	public MyOrder getOrderById(Long id) {
		
		return myOrderRepo.findById(id)
				.orElseThrow(()-> new  MyOrderNotFoundException("Order in not found with id:"+id));
	}

	@Override
	public String delete(Long id) {
		if(!myOrderRepo.existsById(id)) {
			new MyOrderNotFoundException("myOrder is not found with id: "+id);
		}
		return "Order is sueccessfully deleted with id:"+id;
	}

	@Override
	public Page<MyOrder> getAllOrder(Pageable pageable) {
		
		return myOrderRepo.findAll(pageable);
	}

}
