package com.railway.entity;

import java.util.HashMap;

import com.railway.constants.TrainSeatAllocations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TrainSeatAvailability implements TrainSeatAllocations{
	public static HashMap<LocalDate,TrainSeatCount> trainSeatAvailabilityInfo ;

	public HashMap<LocalDate, TrainSeatCount> getStation() {
		return trainSeatAvailabilityInfo;
	}

	public void setStation(HashMap<LocalDate, TrainSeatCount> station) {
		trainSeatAvailabilityInfo = station;
	}
	
	static{
		trainSeatAvailabilityInfo.put(LocalDate.parse("2021/06/01",DateTimeFormatter.ofPattern("yyyy/MM/dd")),new TrainSeatCount(totalSeatCount,waitListCount));
		trainSeatAvailabilityInfo.put(LocalDate.parse("2021/06/02",DateTimeFormatter.ofPattern("yyyy/MM/dd")),new TrainSeatCount(totalSeatCount,waitListCount));
		trainSeatAvailabilityInfo.put(LocalDate.parse("2021/06/03",DateTimeFormatter.ofPattern("yyyy/MM/dd")),new TrainSeatCount(totalSeatCount,waitListCount));
		trainSeatAvailabilityInfo.put(LocalDate.parse("2021/06/04",DateTimeFormatter.ofPattern("yyyy/MM/dd")),new TrainSeatCount(totalSeatCount,waitListCount));
		trainSeatAvailabilityInfo.put(LocalDate.parse("2021/06/05",DateTimeFormatter.ofPattern("yyyy/MM/dd")),new TrainSeatCount(totalSeatCount,waitListCount));
	}
}
