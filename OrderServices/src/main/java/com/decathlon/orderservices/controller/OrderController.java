package com.decathlon.orderservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.decathlon.orderservices.bean.DecaOrder;
import com.decathlon.orderservices.bean.DecaOrderRes;
import com.decathlon.orderservices.bean.DecaOrderUpdate;
import com.decathlon.orderservices.exception.OrderCreateException;
import com.decathlon.orderservices.exception.OrderNotFoundException;
import com.decathlon.orderservices.exception.OrderUpdateException;
import com.decathlon.orderservices.service.OrderService;
import com.decathlon.orderservices.utility.OSUtility;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	OSUtility osUtility;
	
	@PostMapping("/orderCreation")
	public ResponseEntity<Object> orderCreation(@RequestBody DecaOrder order) throws OrderCreateException {
		DecaOrder o = orderService.orderCreation(order);
		return osUtility.buildResponseEntity(new DecaOrderRes(o.getOrderId(), "SUCCESS", "Order created successfully ID-"+o.getOrderId(), HttpStatus.CREATED));
	}
	
	@PutMapping("/orderStatusUpdation")
	public ResponseEntity<Object> orderStatusUpdation(@RequestBody DecaOrderUpdate orderUpdate) throws OrderNotFoundException, OrderUpdateException {
		DecaOrder o = orderService.orderStatusUpdation(orderUpdate);
		return osUtility.buildResponseEntity(new DecaOrderRes(o.getOrderId(), "SUCCESS", "Order updated successfully ID-"+o.getOrderId(), HttpStatus.ACCEPTED));
	}
	
	@GetMapping("getOrderDetails/{id}")
	public DecaOrder getOrderDetails(@PathVariable Long id) throws OrderNotFoundException {
		return orderService.getOrderDetails(id);
	}
}
