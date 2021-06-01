package com.railway.view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.railway.entity.Passenger;
import com.railway.entity.TicketData;
import com.railway.utility.TrainFacilities;

public class TicketBooker {
	private final Scanner scan = new Scanner(System.in);
	int bookingLimit = 6;
	public TicketBooker() throws InputMismatchException,ParseException {
		System.out.print("Date (yyyy-mm-dd) :");
		String date = scan.next();
		LocalDate journeyDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int sourceStationChoice;
		int destinationStationChoice = 0;
		char sourceStation;
		char destinationStation = 0;
		
		do {
			System.out.print("Source Station :\n1->A\n2->B\n3->C\n4->D ");
			sourceStationChoice = scan.nextInt();
			if(sourceStationChoice>=5 && sourceStationChoice<=0)
				System.out.println("Enter a Valid Station");
		}while(sourceStationChoice>=5 && sourceStationChoice<=0);
		switch(sourceStationChoice) {
		case 1:System.out.print("Destination Station :\n1->B\n2->C\n3->D\n4->E");
			destinationStationChoice = scan.nextInt();
			destinationStationChoice+=65;
			destinationStation = (char)destinationStationChoice;
			break;
		case 2:System.out.print("Destination Station :\n1->C\n2->D\n3->E");
		destinationStationChoice = scan.nextInt();
		destinationStationChoice+=66;
		destinationStation = (char)destinationStationChoice;
		break;
		case 3:System.out.print("Destination Station :\n1->D\n2->E");
		destinationStationChoice = scan.nextInt();
		destinationStationChoice+=67;
		destinationStation = (char)destinationStationChoice;
		break;
		case 4:System.out.print("Destination Station :\n1->E");
		destinationStationChoice = scan.nextInt();
		destinationStationChoice+=68;
		destinationStation = (char)destinationStationChoice;
		break;
		default:System.out.println("Enter Valid Station");
		}
		sourceStationChoice+=64;
		sourceStation = (char) sourceStationChoice;
		int numberOfPassenger ;
		boolean validity ;
		do {
			System.out.print("Number Of Passengers :");
			numberOfPassenger = scan.nextInt();
			validity = numberOfPassenger> bookingLimit; 
			if(validity)
				System.out.println("Please enter valid number of seats which can be maximum of 6");
		}while(validity);
		
		Passenger passengerList[] = new Passenger[numberOfPassenger];
		int k=0;
		for(int passengerInfo=0;passengerInfo<numberOfPassenger;passengerInfo++) {
			System.out.println("Enter name of the Passenger :");
			String passengerName = scan.next();
			Passenger newPassenger = new Passenger(passengerName,sourceStation,destinationStation,
					destinationStationChoice-sourceStationChoice,journeyDate,0);
			passengerList[k++] = newPassenger;
		}
		TicketData passengerTicket =new TrainFacilities().bookTicket(passengerList);
		System.out.println("Date :"+journeyDate.toString()+"\nPNR No. :"+passengerTicket.getPNR()
		+"\nBooking Status :"+passengerTicket.getBookingStatus()+"\nSource station & Destintion Station :"
		+passengerTicket.getPassengerDetails()[0].getSourceStation()+"&"
		+passengerTicket.getPassengerDetails()[0].getDestinationStation());
		System.out.println("Passenger_Name\tSeats_Allocated");
		for(Passenger passengerTicketDetails:passengerTicket.getPassengerDetails()) {
			System.out.println(passengerTicketDetails.getName()+"\t\t"+passengerTicketDetails.getSeatNumber());
		}
	}
}
