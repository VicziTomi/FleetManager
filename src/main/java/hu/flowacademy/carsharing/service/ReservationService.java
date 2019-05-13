package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) { return reservationRepository.save(reservation); }
}
