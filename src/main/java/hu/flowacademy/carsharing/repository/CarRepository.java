package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("FROM Car car WHERE car.expDate > car.now")
    List<Car> validCars();

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByType(String type);


}
