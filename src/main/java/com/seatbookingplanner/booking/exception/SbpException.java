package com.seatbookingplanner.booking.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.seatbookingplanner.booking.models.Booking;



@ControllerAdvice
public class SbpException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String e;
	
	@ExceptionHandler(value = SbpException.class)
	public  ResponseEntity<Booking> sbpException(Exception e) {
		Booking b= new Booking();
		b.setStatus("Exceptopn during booking process ");
		return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
	}

	
	public SbpException() {
		super();
		
	}


	public String getE() {
		return e;
	}


	public void setE(String e) {
		this.e = e;
	}


	public SbpException(String e) {
		super();
		this.e = e;
	}
	
	
}
