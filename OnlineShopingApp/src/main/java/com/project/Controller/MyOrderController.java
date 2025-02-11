package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.MyOrderService;
import com.project.entites.MyOrder;

@RestController
@RequestMapping("myOrders")
public class MyOrderController {

	@Autowired
	MyOrderService myOrderService;

	@PostMapping
	ResponseEntity<MyOrder> createMyOrder(@RequestBody MyOrder order) {
		MyOrder order2 = myOrderService.createOrder(order);
		return new ResponseEntity<MyOrder>(order2, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	ResponseEntity<MyOrder> updateMyOrder(@RequestBody MyOrder myorder,@PathVariable Long id) {

		MyOrder updateOrder = myOrderService.updateOrder(myorder, id);
		return new ResponseEntity<MyOrder>(updateOrder, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	ResponseEntity<MyOrder> getById(@PathVariable Long id) {
		MyOrder orderById = myOrderService.getOrderById(id);
		return new ResponseEntity<MyOrder>(orderById, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {
		String delete = myOrderService.delete(id);
		return new ResponseEntity<String>(delete, HttpStatus.OK);

	}

	@GetMapping
	ResponseEntity<Page<MyOrder>> getAll(

			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "20") int size) {
		return ResponseEntity.ok(myOrderService.getAllOrder(PageRequest.of(page, size)));

	}

}
