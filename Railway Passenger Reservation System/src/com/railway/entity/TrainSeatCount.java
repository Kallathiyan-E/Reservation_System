package com.railway.entity;

public class TrainSeatCount {
	private int seatCount;
	private int waitListCount;
	
	public TrainSeatCount(int seatCount, int waitListCount) {
		this.seatCount = seatCount;
		this.waitListCount = waitListCount;
	}
	
	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getWaitListCount() {
		return waitListCount;
	}

	public void setWaitListCount(int waitListCount) {
		this.waitListCount = waitListCount;
	}
}
