package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.exception.CarDeleteViolationException;
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

    public Car save(Car car) { return carRepository.save(car); }

    public void delete(String id) {
        try {
            carRepository.deleteById(id);
        } catch (CarNotExistsException | CarDeleteViolationException e) {
            e.getMessage();
        }
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public Car getOneCar(String id) {
        if (carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get();
        }
        throw new CarNotExistsException(id);
    }


}
