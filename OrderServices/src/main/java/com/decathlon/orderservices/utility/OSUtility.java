package com.decathlon.orderservices.utility;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.decathlon.orderservices.bean.DecaOrderRes;

@Component
public class OSUtility {

	public ResponseEntity<Object> buildResponseEntity(DecaOrderRes orderResponse) {
		return new ResponseEntity<Object>(orderResponse, orderResponse.getStatus());
	}
}
