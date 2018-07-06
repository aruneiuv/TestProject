package com.decathlon.orderservices.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.decathlon.orderservices.utility.ModeOfBuying;
import com.decathlon.orderservices.utility.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class DecaOrder {

	@Id
	private Long orderId;
	private Date orderDate;
	private String customerName;
	@Enumerated(EnumType.STRING)
	private ModeOfBuying modeOfBuying;
	@JsonInclude(Include.NON_NULL)
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	public DecaOrder() {
		super();
	}
	public DecaOrder(Long orderId, Date orderDate, String customerName, ModeOfBuying modeOfBuying,
			OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.modeOfBuying = modeOfBuying;
		this.orderStatus = orderStatus;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ModeOfBuying getModeOfBuying() {
		return modeOfBuying;
	}
	public void setModeOfBuying(ModeOfBuying modeOfBuying) {
		this.modeOfBuying = modeOfBuying;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
