package com.seatbookingplanner.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seatbookingplanner.booking.models.Book;
import com.seatbookingplanner.booking.models.Booking;



public interface SbpRepository extends JpaRepository<Book, Long>{
	
	
	public Optional<Book> findById(Long id);
	public List<Book> findAll();
	
}
