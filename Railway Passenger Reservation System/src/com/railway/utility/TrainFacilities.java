package com.railway.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.railway.entity.Passenger;
import com.railway.entity.TicketData;
import com.railway.entity.TrainSeatAvailability;
import com.railway.entity.TrainSeatCount;

public class TrainFacilities {
	int PNR;
	int cancelCount;
	TrainSeatAvailability trainSeat = new TrainSeatAvailability();
	HashMap<LocalDate,TrainSeatCount> trainSeatAvailabilityInfo = trainSeat.getStation();
	ArrayList<TicketData> ticketRecord = new ArrayList<>();
	public void bookTicket(Passenger[] passengersInfo) {
		passengersInfo = sortByLongestRoute(passengersInfo);
		String status = null;
		for(LocalDate date:trainSeatAvailabilityInfo.keySet()){
			if(date.equals(passengersInfo[0].getJourneyDate())) {
				int seatAvailable = trainSeatAvailabilityInfo.get(date).getSeatCount();
				int waitListAvailable = trainSeatAvailabilityInfo.get(date).getWaitListCount();
				if(seatAvailable>0) {
					status = "Booked";
					trainSeatAvailabilityInfo.get(date).setSeatCount(passengersInfo.length);
				}else if(waitListAvailable>0) {
					status = "Waiting List";
					trainSeatAvailabilityInfo.get(date).setWaitListCount(passengersInfo.length);
				}
				else
					status = "Not Booked";
			}	
		}
		 ticketRecord.add(new TicketData(PNR++,passengersInfo,status));
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
	
	public void cancelTicket() {
		
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
