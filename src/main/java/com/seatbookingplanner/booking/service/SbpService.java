package com.seatbookingplanner.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.seatbookingplanner.booking.exception.SbpException;
import com.seatbookingplanner.booking.models.Book;
import com.seatbookingplanner.booking.models.Booking;
import com.seatbookingplanner.booking.repository.SbpRepository;



@Service
public class SbpService {

	@Autowired
	SbpRepository sbpRepository;

	public Long addNewBooking(Booking booking) throws SbpException {
		System.out.println(booking.getBookingDate());
		Book b = new Book();
		b.setId(booking.getId());
		b.setBookingDate(booking.getBookingDate());
		b.setBookingSlot(booking.getBookingSlot());
		b.setEmployeeId(booking.getEmployeeId());
		b.setFloorNumber(booking.getFloorNumber());
		b.setOfficeAddress(booking.getOfficeAddress());
		b.setSeatNumber(booking.getSeatNumber());
		b.setRole(booking.getRole());
		b.setCancel(booking.getCancel());
		return sbpRepository.save(b).getId();
	}

	public List<Booking> getBookingById(Long id) throws SbpException {

		Book b = sbpRepository.findById(id).get();
		List<Booking> booklist = new ArrayList<>();
		Booking booking = null;
		if(null!= b) {
		booking = new Booking();
		booking.setId(b.getId());
		booking.setBookingDate(b.getBookingDate());
		booking.setBookingSlot(b.getBookingSlot());
		booking.setEmployeeId(b.getEmployeeId());
		booking.setFloorNumber(b.getFloorNumber());
		booking.setOfficeAddress(b.getOfficeAddress());
		booking.setSeatNumber(b.getSeatNumber());
		booklist.add(booking);
		}
		return booklist;
	}
	
//	public Optional<Book> getBookingById(Long id) throws SbpException {
//		
//		return sbpRepository.findById(id);
//		//return sbpRepository.findById(id);
//		
//	}

	public List<Booking> getAllBooking() throws SbpException{
		List<Booking> booklist = new ArrayList<>();
		List<Book> bookingList = sbpRepository.findAll();
		if(!CollectionUtils.isEmpty(bookingList)) {
			for (Book book : bookingList) {
				Booking b = new Booking();
				b.setBookingDate(book.getBookingDate());
				b.setBookingSlot(book.getBookingSlot());
				b.setEmployeeId(book.getEmployeeId());
				b.setFloorNumber(book.getFloorNumber());
				b.setId(book.getId());
				b.setOfficeAddress(book.getOfficeAddress());
				b.setSeatNumber(book.getSeatNumber());
				b.setCancel(book.getCancel());
				booklist.add(b);
			}
		}
		return booklist;
	}
	
	public String updateBooking(Booking b) throws SbpException {

		Book booking = sbpRepository.findById(b.getId()).get();
		
		if(null!= b) {
		booking.setBookingDate(b.getBookingDate());
		booking.setBookingSlot(b.getBookingSlot());
		booking.setEmployeeId(b.getEmployeeId());
		booking.setFloorNumber(b.getFloorNumber());
		booking.setOfficeAddress(b.getOfficeAddress());
		booking.setSeatNumber(b.getSeatNumber());
		}
		sbpRepository.save(booking);
		return "Booking details updated successfully";
	}
	public String cancelBooking(Booking b) throws SbpException {
		Book booking = sbpRepository.findById(b.getId()).get();
		
		if(null!= b) {
			booking.setCancel(b.getCancel());
		}
		sbpRepository.save(booking);
		return "Booking details cancelled successfully";
	}
	

}