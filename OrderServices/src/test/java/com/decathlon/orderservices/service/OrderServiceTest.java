package com.decathlon.orderservices.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.decathlon.orderservices.bean.DecaOrder;
import com.decathlon.orderservices.exception.OrderCreateException;
import com.decathlon.orderservices.repository.OrderRepository;
import com.decathlon.orderservices.service.serviceimpl.OrderServiceImpl;
import com.decathlon.orderservices.utility.ModeOfBuying;
import com.decathlon.orderservices.utility.OrderStatus;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderServiceImpl orderService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void orderCreation() throws OrderCreateException{
		Date today = new Date();
		DecaOrder order = new DecaOrder(2L,today,"Test Customer",ModeOfBuying.Store, OrderStatus.Shipped);
		when(orderRepository.save(order)).thenReturn(order);
		DecaOrder result = orderService.orderCreation(order);
		assertEquals(2, result.getOrderId().longValue());
		assertEquals("Test Customer", result.getCustomerName());
		assertEquals(ModeOfBuying.Store, result.getModeOfBuying());
		assertEquals(OrderStatus.Shipped, result.getOrderStatus());
	}
}
