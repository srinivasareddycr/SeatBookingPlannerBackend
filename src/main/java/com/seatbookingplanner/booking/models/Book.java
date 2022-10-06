package com.seatbookingplanner.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	String employeeId;
	@Column(nullable = false)
	String officeAddress;
	String floorNumber;
	@Column(nullable = false)
	String seatNumber;
	@Column(nullable = false)
	String bookingDate;
	@Column(nullable = false)
	String bookingSlot;
	String cancel;
	@Column(nullable = false)
	String role;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingSlot() {
		return bookingSlot;
	}

	public void setBookingSlot(String bookingSlot) {
		this.bookingSlot = bookingSlot;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", employeeId=" + employeeId + ", officeAddress=" + officeAddress + ", floorNumber="
				+ floorNumber + ", seatNumber=" + seatNumber + ", bookingDate=" + bookingDate + ", bookingSlot="
				+ bookingSlot + ", cancel=" + cancel + ", role=" + role + "]";
	}

	public Book(Long id, String employeeId, String officeAddress, String floorNumber, String seatNumber,
			String bookingDate, String bookingSlot, String cancel, String role) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.officeAddress = officeAddress;
		this.floorNumber = floorNumber;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.bookingSlot = bookingSlot;
		this.cancel = cancel;
		this.role = role;
	}

	
	
}

