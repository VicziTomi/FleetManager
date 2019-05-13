package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.repository.CarRepository;
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

    public Car add(Car car) { return carRepository.save(car); }

    public void delete(String id) {
        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getOneCar(String id) {
        return carRepository.findById(id);
    }


}
