package com.cust.vehicle.monitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class ElementNullException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ElementNullException() {
		super();
	}
	
	public ElementNullException(String message){
		
		super(message);
	}
	
	public ElementNullException(String message, Throwable cause){
		
		super(message, cause);
	}
	
	public ElementNullException(Throwable cause) {
		
		super(cause);
	}
	
	
}

