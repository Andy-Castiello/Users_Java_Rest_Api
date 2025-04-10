package com.demo.UsersRestApi.dto;

public class SaveReservationDto {

	private long reservationNumber;
	private String startDate;
	private String endDate;
	private long userId;

	public SaveReservationDto() {
		super();
	}

	public SaveReservationDto(String startDate, String endDate, long userId) {
		super();
		this.reservationNumber = -1;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
	}

	public SaveReservationDto(long reservationNumber, String startDate, String endDate, long userId) {
		super();
		this.reservationNumber = reservationNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
	}

	public long getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(long reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
