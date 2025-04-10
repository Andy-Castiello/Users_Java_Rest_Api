package com.demo.UsersRestApi.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reservationNumber;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonBackReference
	private UserEntity user;

	public Reservation() {
		super();
	}

	public Reservation(LocalDateTime startDate, LocalDateTime endDate, UserEntity userEntity) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = userEntity;
	}

	public Reservation(long reservationNumber, LocalDateTime startDate, LocalDateTime endDate, UserEntity userEntity) {
		super();
		this.reservationNumber = reservationNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = userEntity;
	}

	public long getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(long reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity userEntity) {
		this.user = userEntity;
	}
}
