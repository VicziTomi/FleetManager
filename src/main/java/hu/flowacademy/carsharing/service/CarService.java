package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.exception.CarDeleteViolationException;
import hu.flowacademy.carsharing.exception.CarHasValidReservationsException;
import hu.flowacademy.carsharing.exception.CarNotExistsException;
import hu.flowacademy.carsharing.repository.CarRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ReservationService reservationService;

    public Car save(Car car) { return carRepository.save(car); }

    public void delete(String id) {
        try {
            carRepository.deleteById(id);
        } catch (CarNotExistsException | CarDeleteViolationException e) {
            e.getMessage();
        }
    }

    public boolean validDelete(String plateNumber) {
        List<Reservation> reservationList = reservationService.listReservationsById(plateNumber);
        System.out.println(reservationList);
        for (Reservation r: reservationList) {
            if (reservationList.isEmpty()) {
                carRepository.deleteById(plateNumber);
                return true;
            } else if (r.getReservationEnd().isBefore(carRepository.getOne(plateNumber).getNow())) {
                carRepository.deleteById(plateNumber);
                return true;
            }
        }
        throw new CarHasValidReservationsException();
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public List<Car> listCarsByBrand(String brand) {
        return carRepository.findAllByBrand(brand);
    }

    public List<Car> listCarsByType(String type) {
        return carRepository.findAllByType(type);
    }

    public Car getOneCar(String id) {
        if (carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get();
        }
        throw new CarNotExistsException(id);
    }

    public List<Car> validCars() {
        return carRepository.validCars();
    }


}
