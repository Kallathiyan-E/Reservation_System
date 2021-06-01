package com.railway.view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.railway.utility.TrainFacilities;

public class TicketCounter {

	private final Scanner scan = new Scanner(System.in);	
	public void menu() throws InputMismatchException, ParseException{
		
		int entryChoice;
		do {
			System.out.println("1->Book Ticket\n2->Train Booking Status\n3->Cancel Ticket\n4->Prepare Chart");
			System.out.print("Enter your Choice :");
			entryChoice = scan.nextInt();
			switch(entryChoice) {
			case 1:new TicketBooker();
				break;
			case 2:System.out.println("Enter the Date (yyyy-MM-dd):");
				String requiredDate = scan.next();
				System.out.println(new TrainFacilities().trainBookingStatus(LocalDate.parse(requiredDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
				break;
			case 3:System.out.println("Cancel Ticket BY \n1=>PNR\n2=>Name and PNR");
				int cancelChoice =scan.nextInt();
				switch(cancelChoice) {
				case 1:System.out.println("Enter the PNR :");
					int PNR = scan.nextInt();
					new TrainFacilities().cancelTicketByPNR(PNR);
					break;
				case 2:System.out.println("Enter the PNR :");
					PNR = scan.nextInt();
					String name = scan.next();
					new TrainFacilities().cancelTicketByName(PNR,name);
				}
				break;
			case 4:System.out.println("Enter the Date (yyyy-MM-dd):");
					requiredDate = scan.next();
					new TrainFacilities().prepareRecord(LocalDate.parse(requiredDate,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				break;
			default:System.out.println("Enter a Valid Choice");
			}
		}while(true);
		
	}
}
