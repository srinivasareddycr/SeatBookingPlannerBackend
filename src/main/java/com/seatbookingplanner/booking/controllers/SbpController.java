package com.seatbookingplanner.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatbookingplanner.booking.exception.SbpException;
import com.seatbookingplanner.booking.models.Book;
import com.seatbookingplanner.booking.models.Booking;
import com.seatbookingplanner.booking.service.SbpService;



@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/sbp/api/v1")
public class SbpController {
	@Autowired
	SbpService sbpService;

//	@GetMapping("/all")
//	public String allAccess() {
//		return "Seat Booking planner ..";
//	}
//
//	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
//	public String userAccess() {
//		return "User Content.";
//	}
//
//	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
//	public String adminAccess() {
//		return "Admin Board.";
//	}

	@PostMapping("/emp/booking")
	@PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
	public Long addNewBooking(@RequestBody Booking booking) throws SbpException {
		sbpService.addNewBooking(booking);
		booking.setStatus("New Booking added successfully..");
		return booking.getId();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
	public List<Booking> getBookingById(@PathVariable Long id) throws SbpException {
		return sbpService.getBookingById(id);
	}

	@GetMapping("/getAllBooking")
	@PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
	public List<Booking> getAllBooking() throws SbpException {
		return sbpService.getAllBooking();
	}

	@PutMapping("/updateBooking")
	@PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
	public String updateBooking(@RequestBody Booking booking) throws SbpException {
		return sbpService.updateBooking(booking);
	}

	@PutMapping("/cancelBooking")
	@PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
	public String cancelBooking(@RequestBody Booking booking) throws SbpException {
		return sbpService.cancelBooking(booking);
	}
}
