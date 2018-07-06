package com.decathlon.orderservices.service;

import javax.transaction.Transactional;

import com.decathlon.orderservices.bean.DecaOrder;
import com.decathlon.orderservices.bean.DecaOrderUpdate;
import com.decathlon.orderservices.exception.OrderCreateException;
import com.decathlon.orderservices.exception.OrderNotFoundException;
import com.decathlon.orderservices.exception.OrderUpdateException;

@Transactional
public interface OrderService {

	public DecaOrder orderCreation(DecaOrder order) throws OrderCreateException;
	public DecaOrder getOrderDetails(Long id) throws OrderNotFoundException;
	public DecaOrder orderStatusUpdation(DecaOrderUpdate orderUpdate) throws OrderNotFoundException, OrderUpdateException;
}
