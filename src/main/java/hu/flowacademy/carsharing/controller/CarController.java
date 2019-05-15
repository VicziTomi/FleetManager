package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/allcars")
    public  ResponseEntity<List<Car>> allCars () {
        return ResponseEntity.ok(carService.listCars());
    }

    @GetMapping("/onecar/{id}")
    public ResponseEntity<Car> oneCar(@PathVariable String id) {
        return ResponseEntity.ok(carService.getOneCar(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        carService.delete(id);
    }
}
