package com.demo.UsersRestApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.UsersRestApi.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
