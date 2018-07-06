package com.decathlon.orderservices.exception;

public class OrderNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2899872346006102817L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
