package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UsersRestApi.model.Reservation;
import com.demo.UsersRestApi.model.User;
import com.demo.UsersRestApi.repository.ReservationRepository;
import com.demo.UsersRestApi.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return (ArrayList<Reservation>) reservationRepository.findAll();
	}

	@Override
	public ArrayList<Reservation> getReservationsByUser(User user) {
		// TODO Auto-generated method stub

		return (ArrayList<Reservation>) user.getReservations();

	}

	@Override
	public Optional<Reservation> getReservationById(long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id);
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub

		return reservationRepository.save(reservation);
	}

	@Override
	public boolean deleteReservationById(long id) {
		// TODO Auto-generated method stub

		Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isPresent()) {

			try {

				reservationRepository.delete(reservation.get());
				return true;

			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		return false;
	}

}
