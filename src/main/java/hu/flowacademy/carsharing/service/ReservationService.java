package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.CarsharingApplication;
import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.exception.ReservationConflictException;
import hu.flowacademy.carsharing.exception.ReservationNotFoundException;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarService carService;

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation validatedSave(Reservation reservation, String id) {
        List<Reservation> resCars = listReservationsById(id);
        if (resCars == null) {
            return reservationRepository.save(reservation);
        } else {
            for (Reservation r : resCars) {
                if (reservation.getReservationStart().isBefore(reservation.getReservationEnd()) && reservation.getReservationEnd().isBefore(r.getReservationStart())) {
                    reservation.setCar(carService.getOneCar(id));
                    System.out.println(resCars);
                    return reservationRepository.save(reservation);
                } else if (reservation.getReservationEnd().isAfter(reservation.getReservationStart()) && reservation.getReservationStart().isAfter(r.getReservationEnd())) {
                    reservation.setCar(carService.getOneCar(id));
                    return reservationRepository.save(reservation);
                } else {
                    throw new ReservationConflictException();
                }
            }
            throw new ReservationConflictException();
        }
    }

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

    public List<Reservation> listByDriver(String driver) {
        return reservationRepository.findByDriver_LoginName(driver);
    }

    public List<Reservation> listByCar(String plateNumber) {
        return reservationRepository.findByCar_PlateNumber(plateNumber);
    }

    public List<Reservation> listByPeriod(HashMap start, HashMap end) {
        return reservationRepository.findByResPeriod(start, end);
    }

    public List<Reservation> listReservationsById(String plateNumber) {
        return reservationRepository.findAllByCar_PlateNumber(plateNumber);
    }
}
