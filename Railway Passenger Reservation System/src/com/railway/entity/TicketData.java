package com.railway.entity;

public class TicketData {
	private int PNR;
	private Passenger[] passengerDetails;
	private String bookingStatus;
	
	public TicketData(int PNR, Passenger[] passengerDetails, String bookingStatus) {
		this.PNR = PNR;
		this.passengerDetails = passengerDetails;
		this.bookingStatus = bookingStatus;
	}
	public int getPNR() {
		return PNR;
	}
	public void setPNR(int PNR) {
		this.PNR = PNR;
	}
	public Passenger[] getPassengerDetails() {
		return passengerDetails;
	}
	public void setPassengerDetails(Passenger[] passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
