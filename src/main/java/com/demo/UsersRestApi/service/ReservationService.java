package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import com.demo.UsersRestApi.model.Reservation;
import com.demo.UsersRestApi.model.UserEntity;

public interface ReservationService {

	ArrayList<Reservation> getAllReservations();

	ArrayList<Reservation> getReservationsByUser(UserEntity userEntity);

	Optional<Reservation> getReservationById(long id);

	Reservation saveReservation(Reservation reservation);

	boolean deleteReservationById(long id);
}
