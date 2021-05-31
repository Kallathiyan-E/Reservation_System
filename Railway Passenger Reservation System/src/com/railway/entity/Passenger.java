package com.railway.entity;

import java.time.LocalDate;

public class Passenger extends Person{
	private char sourceStation;
	private char destinationStation;
	private int travellingDistance;
	private LocalDate journeyDate;	
	private int seatNumber;
	
	public Passenger(String name, char sourceStation, char destinationStation,int travellingDistance,
			LocalDate journeyDate,int seatNumber) {
		super(name);
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travellingDistance = travellingDistance;
		this.journeyDate = journeyDate;
		this.seatNumber = seatNumber;
	}

	public char getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(char sourceStation) {
		this.sourceStation = sourceStation;
	}
	public char getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(char destinationStation) {
		this.destinationStation = destinationStation;
	}
	
	public int getTravellingDistance() {
		return travellingDistance;
	}

	public void setTravellingDistance(int travellingDistance) {
		this.travellingDistance = travellingDistance;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	
}
