package com.railway.main;

import java.text.ParseException;
import java.util.InputMismatchException;

import com.railway.view.TicketCounter;

public class PassengerReservationSystem {
	
	public static void main(String[] args) {
		TicketCounter counter = new TicketCounter();
		do {
			try {
				counter.menu();
			} catch (InputMismatchException | ParseException e) {
				System.out.println("Invalid Input");
				e.printStackTrace();
			}
		}while(true);
	}
}
