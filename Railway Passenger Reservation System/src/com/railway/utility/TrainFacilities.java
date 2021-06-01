package com.railway.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.railway.entity.Passenger;
import com.railway.entity.TicketData;
import com.railway.entity.TrainSeatAvailability;
import com.railway.entity.TrainSeatCount;

public class TrainFacilities {
	int PNR=1;
	int cancelCount;
	TrainSeatAvailability trainSeat = new TrainSeatAvailability();
	HashMap<LocalDate,TrainSeatCount> trainSeatAvailabilityInfo = trainSeat.getStation();
	ArrayList<TicketData> ticketRecord = new ArrayList<>();
	public TicketData bookTicket(Passenger[] passengersInfo) {
		int requiredSeatCount = passengersInfo.length;
		passengersInfo = sortByLongestRoute(passengersInfo);
		String status = null;
		for(LocalDate date:trainSeatAvailabilityInfo.keySet()){
			if(date.equals(passengersInfo[0].getJourneyDate())) {
				int seatAvailable = trainSeatAvailabilityInfo.get(date).getSeatCount();
				int waitListAvailable = trainSeatAvailabilityInfo.get(date).getWaitListCount();
				if(seatAvailable>0 && requiredSeatCount<seatAvailable) {
					status = "Booked";
					trainSeatAvailabilityInfo.get(date).setSeatCount(seatAvailable-requiredSeatCount);
					for(Passenger details:passengersInfo) {
						details.setSeatNumber(seatAvailable--);
					}
				}else if(waitListAvailable>0 && requiredSeatCount<waitListAvailable) {
					status = "Waiting List";
					trainSeatAvailabilityInfo.get(date).setWaitListCount(passengersInfo.length);
					for(Passenger details:passengersInfo) {
						details.setSeatNumber(waitListAvailable--);
					}
				}
				else
					status = "Not Booked";
			}	
		}
		TicketData newTicket = new TicketData(PNR++,passengersInfo,status);
		ticketRecord.add(newTicket);
		return newTicket;
		 
	}
	
	public String trainBookingStatus(LocalDate day) {
		for(LocalDate date:trainSeatAvailabilityInfo.keySet()){
			if(date.equals(day)) {
				return "Booked :"+(100-trainSeatAvailabilityInfo.get(date).getSeatCount())+"\n"
						+"Open :"+trainSeatAvailabilityInfo.get(date).getSeatCount()+"\n"
						+"Waiting List :"+trainSeatAvailabilityInfo.get(date).getWaitListCount()+"\n"
						+"Cancelled :"+cancelCount;
			}
		}
		return "Train on the Date is Not Available";
	}
	
	public boolean cancelTicketByPNR(int PNR) {
		for(TicketData data:ticketRecord) {
			if(PNR==data.getPNR()) {
				cancelCount++;
				return ticketRecord.remove(data);
			}
		}
		return false;
	}
	
	public boolean cancelTicketByName(int PNR,String name) {
		for(TicketData data:ticketRecord) {
			if(data.getPNR()==PNR) {
				for(Passenger passengerDetail :data.getPassengerDetails()) {
					if(passengerDetail.getName().equals(name)) {
						cancelCount++;
						passengerDetail=null;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void prepareRecord(LocalDate date) {
		System.out.println("PNR\tName\tSource\tdestination\tSeat_No");
		for(TicketData data:ticketRecord) {
			for(Passenger passengerDetail :data.getPassengerDetails()) {
				if(passengerDetail.getJourneyDate().equals(date)) {
					System.out.println(data.getPNR()+"\t"+passengerDetail.getName()+"\t"+passengerDetail.getSourceStation()
					+"\t"+passengerDetail.getDestinationStation()+"\t"+passengerDetail.getSeatNumber());
				}
			}
		}
	}
	
	public Passenger[] sortByLongestRoute(Passenger[] passengersDetails) {
		int size = passengersDetails.length;
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j<size;j++) {
				if(passengersDetails[i].getTravellingDistance()<passengersDetails[j].getTravellingDistance()) {
					Passenger temp = passengersDetails[i];
					passengersDetails[i] = passengersDetails[j];
					passengersDetails[j] = temp;
				}
			}
		}
		return passengersDetails;
	}
}
