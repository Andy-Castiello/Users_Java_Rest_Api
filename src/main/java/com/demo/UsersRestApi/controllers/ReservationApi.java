package com.demo.UsersRestApi.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.UsersRestApi.dto.SaveReservationRequest;
import com.demo.UsersRestApi.model.Reservation;
import com.demo.UsersRestApi.model.User;
import com.demo.UsersRestApi.service.ReservationService;
import com.demo.UsersRestApi.service.UserService;

@RestController
@RequestMapping("api/reservations")
public class ReservationApi {

	@Autowired
	UserService userService;

	@Autowired
	ReservationService reservationService;

	@GetMapping("/all")
	public ArrayList<Reservation> getAllReservations() {

		return reservationService.getAllReservations();
	}

	@GetMapping("/find/{id}")
	public Optional<Reservation> getReservationById(@PathVariable("id") long id) {

		return reservationService.getReservationById(id);
	}

	@GetMapping("/findByUserId/{id}")
	public ArrayList<Reservation> getReservationByUserId(@PathVariable("id") long id) {

		Optional<User> user = userService.getUserById(id);
		if (user.isPresent()) {

			return reservationService.getReservationsByUser(user.get());

		} else {

			return new ArrayList<Reservation>();
		}
	}

	@PostMapping("/save")
	public Reservation saveReservation(@RequestBody SaveReservationRequest saveReservationRequest) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		LocalDateTime startDate = LocalDateTime.parse(saveReservationRequest.getStartDate(), formatter);
		LocalDateTime endDate = LocalDateTime.parse(saveReservationRequest.getEndDate(), formatter);

		Optional<User> user = userService.getUserById(saveReservationRequest.getUserId());

		if (user.isPresent()) {

			if (saveReservationRequest.getReservationNumber() >= 0) {

				Reservation reservation = new Reservation(saveReservationRequest.getReservationNumber(), startDate,
						endDate, user.get());
				return reservationService.saveReservation(reservation);

			} else {

				Reservation reservation = new Reservation(startDate, endDate, user.get());
				return reservationService.saveReservation(reservation);

			}

		} else {

			return null;
		}

	}

	@DeleteMapping("/delete/{id}")
	public String deleteReservationById(@PathVariable("id") long id) {

		if (reservationService.deleteReservationById(id)) {

			return "The reservations was deleted successfully!";
		} else {

			return "Something went wrong! The reservation couldn´t be deleted";
		}
	}

}
