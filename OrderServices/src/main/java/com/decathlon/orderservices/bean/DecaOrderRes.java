package com.decathlon.orderservices.bean;

import org.springframework.http.HttpStatus;

public class DecaOrderRes {

	private Long id;
	private String type;
	private String message;
	private HttpStatus status;
	public DecaOrderRes() {
		super();
	}
	public DecaOrderRes(Long id, String type, String message, HttpStatus status) {
		super();
		this.id = id;
		this.type = type;
		this.message = message;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
