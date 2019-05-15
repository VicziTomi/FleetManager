package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.exception.ReservationNotFoundException;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) { return reservationRepository.save(reservation); }

    public void delete(String id) {
        try {
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Reservation> listReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getOneReservation(String id) {
        if (reservationRepository.findById(id).isPresent()) {
            return reservationRepository.findById(id).get();
        }
        throw new ReservationNotFoundException(id);
    }
}
