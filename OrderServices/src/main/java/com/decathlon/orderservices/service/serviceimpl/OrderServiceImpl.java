package com.decathlon.orderservices.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decathlon.orderservices.bean.DecaOrder;
import com.decathlon.orderservices.bean.DecaOrderUpdate;
import com.decathlon.orderservices.exception.OrderCreateException;
import com.decathlon.orderservices.exception.OrderNotFoundException;
import com.decathlon.orderservices.exception.OrderUpdateException;
import com.decathlon.orderservices.repository.OrderRepository;
import com.decathlon.orderservices.service.OrderService;
import com.decathlon.orderservices.utility.ModeOfBuying;
import com.decathlon.orderservices.utility.OSUtility;
import com.decathlon.orderservices.utility.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OSUtility osUtility;

	@Override
	public DecaOrder orderCreation(DecaOrder order) throws OrderCreateException {
		Optional<DecaOrder> optionalOrder = orderRepository.findById(order.getOrderId());
		if(optionalOrder.isPresent()) {
			throw new OrderCreateException("Order already exists id-" + order.getOrderId());
		}
		if(order.getModeOfBuying() == ModeOfBuying.Store) {
			order.setOrderStatus(OrderStatus.Shipped);
		} else {
			order.setOrderStatus(OrderStatus.PreparedForShippeing);
		}
		return orderRepository.save(order);
	}

	@Override
	public DecaOrder orderStatusUpdation(DecaOrderUpdate orderUpdate) throws OrderNotFoundException, OrderUpdateException {
		Optional<DecaOrder> optionalOrder = orderRepository.findById(orderUpdate.getId());
		if(!optionalOrder.isPresent()) {
			throw new OrderNotFoundException("Requested order details not found id-" + orderUpdate.getId());
		}
		DecaOrder oldOrder = optionalOrder.get();
		if(oldOrder.getModeOfBuying() == ModeOfBuying.Online && orderUpdate.getOs() != OrderStatus.PreparedForShippeing && oldOrder.getOrderStatus() == OrderStatus.PreparedForShippeing) {
			oldOrder.setOrderStatus(orderUpdate.getOs());
			return orderRepository.save(oldOrder);
		}
		throw new OrderUpdateException("Requested order cannot be updated id-" + orderUpdate.getId());
	}

	@Override
	public DecaOrder getOrderDetails(Long id) throws OrderNotFoundException {
		Optional<DecaOrder> student = orderRepository.findById(id);

		if (!student.isPresent())
			throw new OrderNotFoundException("Requested order details not found id-" + id);

		return student.get();
	}

}
