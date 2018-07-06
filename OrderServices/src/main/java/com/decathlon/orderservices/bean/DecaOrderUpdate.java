package com.decathlon.orderservices.bean;

import com.decathlon.orderservices.utility.OrderStatus;

public class DecaOrderUpdate {

	private Long id;
	private OrderStatus os;
	public DecaOrderUpdate() {
		super();
	}
	public DecaOrderUpdate(Long id, OrderStatus os) {
		super();
		this.id = id;
		this.os = os;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OrderStatus getOs() {
		return os;
	}
	public void setOs(OrderStatus os) {
		this.os = os;
	}
}
