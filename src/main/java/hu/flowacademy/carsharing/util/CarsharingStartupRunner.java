package hu.flowacademy.carsharing.util;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Component
public class CarsharingStartupRunner implements CommandLineRunner {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {

        Driver d1 = new Driver("kiskarcsi", "pwd", "Kis Karcsi", LocalDate.of(2021, Month.AUGUST, 12), false );
        Driver d2 = new Driver("marcsiX", "marcsika", "Kis Marcsi", LocalDate.of(1999, Month.DECEMBER, 1), false);
        Driver d3 = new Driver("feri", "gocoding", "Franko Ferenc", LocalDate.of(2023, Month.JANUARY, 2), true);
        Driver d4 = new Driver("MrRobi", "utalomFerit", "Szolga Robert", LocalDate.of(2020, Month.JULY, 23), true);
        driverRepository.save(d1);
        driverRepository.save(d2);
        driverRepository.save(d3);
        driverRepository.save(d4);


        Car c1 = new Car("NHJ637", "Seat", "Toledo", 2015, LocalDate.of(2021, Month.APRIL, 30));
        Car c2 = new Car("KMM914", "Peugeout", "307", 2006, LocalDate.of(2019, Month.MAY, 20));
        Car c3 = new Car("AAA111", "Aston Martin", "DB-5", 1967, LocalDate.of(2023, Month.JANUARY, 1));
        Car c4 = new Car("ABC123", "Lada", "Samara", 1972, LocalDate.of(1996, Month.MARCH, 12));
        Car c5 = new Car("xxx", "VW", "sedan", 2008, LocalDate.of(2020, Month.APRIL, 1));
        Car c6 = new Car("yyy", "Audi", "sedan", 2014, LocalDate.of(2023, Month.APRIL, 1));
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
        carRepository.save(c4);
        carRepository.save(c5);
        carRepository.save(c6);




        Reservation r1 = new Reservation("res1", LocalDateTime.of(2019, Month.MAY, 13, 12, 23), LocalDate.of(2019, Month.MAY, 16), LocalDate.of(2019, Month.MAY, 21), "Mucsaröcsöge");
        Reservation r2 = new Reservation("res2", LocalDateTime.of(2019, Month.MAY, 23, 21, 12), LocalDate.of(2019, Month.JUNE, 8), LocalDate.of(2019, Month.JUNE, 18), "Monaco");
        Reservation r3 = new Reservation("res3", LocalDateTime.of(2019, Month.APRIL, 29, 3, 10), LocalDate.of(2019, Month.MAY, 5), LocalDate.of(2019, Month.MAY, 25), "Kukutyim");
        Reservation r4 = new Reservation("res4", LocalDateTime.of(2019, Month.MAY, 13, 6, 34), LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 5), "Büdipest");
        Reservation r5 = new Reservation("res5", LocalDateTime.of(2019, Month.MAY, 12, 14, 56), LocalDate.of(2019, Month.AUGUST, 3), LocalDate.of(2019, Month.AUGUST,9), "Csóka");
        r1.setCar(c1);
        r1.setDriver(d1);

        r2.setCar(c2);
        r2.setDriver(d2);

        r3.setCar(c3);
        r3.setDriver(d3);

        r4.setCar(c1);
        r4.setDriver(d4);

        r5.setCar(c3);
        r5.setDriver(d2);

        reservationRepository.save(r1);
        reservationRepository.save(r2);
        reservationRepository.save(r3);
        reservationRepository.save(r4);
        reservationRepository.save(r5);



    }
}
