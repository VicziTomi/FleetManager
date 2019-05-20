package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.exception.DriverHasValidReservationException;
import hu.flowacademy.carsharing.exception.DriverNotFoundException;
import hu.flowacademy.carsharing.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationService reservationService;

    public Driver save(Driver driver) { return driverRepository.save(driver); }

    public void delete(String id) {
        try {
            driverRepository.deleteById(id);
        } catch (DriverNotFoundException e) {
            e.getMessage();
        }
    }

    public void validDelete(String id) {
        List<Reservation> reservations = reservationService.listByDriver(id);
        if (reservations.isEmpty()) {
            driverRepository.deleteById(id);
        }

        for (Reservation r: reservations) {
            if (r.getReservationEnd().isBefore(LocalDate.now())) {
                reservationService.deleteByDriver(id);
            } else {
                throw new DriverHasValidReservationException(id);
            }
        }
        driverRepository.deleteById(id);

    }

    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    public Driver getOneDriver(String id) {
        if(driverRepository.findById(id).isPresent()) {
            return driverRepository.findById(id).get();
        }
        throw new DriverNotFoundException(id);
    }

}
