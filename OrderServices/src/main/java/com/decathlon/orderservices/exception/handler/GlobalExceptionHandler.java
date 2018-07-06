package com.decathlon.orderservices.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.decathlon.orderservices.bean.DecaOrderRes;
import com.decathlon.orderservices.exception.OrderCreateException;
import com.decathlon.orderservices.exception.OrderNotFoundException;
import com.decathlon.orderservices.exception.OrderUpdateException;
import com.decathlon.orderservices.utility.OSUtility;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private OSUtility osUtility;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> handleBadRequest(OrderNotFoundException oEx) {
		return osUtility.buildResponseEntity(new DecaOrderRes(null, "ERROR", oEx.getLocalizedMessage(), HttpStatus.BAD_REQUEST));
	}
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = OrderCreateException.class)
	public ResponseEntity<Object> handleCreateRequest(OrderCreateException oEx) {
		return osUtility.buildResponseEntity(new DecaOrderRes(null, "ERROR", oEx.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE));
	}
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = OrderUpdateException.class)
	public ResponseEntity<Object> handleUpdateRequest(OrderUpdateException oEx) {
		return osUtility.buildResponseEntity(new DecaOrderRes(null, "ERROR", oEx.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE));
	}
}
