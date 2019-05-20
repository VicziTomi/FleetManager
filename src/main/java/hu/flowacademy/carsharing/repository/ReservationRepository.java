package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    List<Reservation> findAllByCar_PlateNumber(String plateNumber);

    List<Reservation> findByDriver_LoginName(String loginName);

    List<Reservation> findByCar_PlateNumber(String plateNumber);

    @Query(value = "SELECT * FROM Reservation res WHERE res.reservation_start > ?1 AND res.reservation_end < ?2", nativeQuery = true)
    List<Reservation> findByResPeriod(@Param("reservation_start") HashMap<String, LocalDate> reservation_start, @Param("reservation_end") HashMap<String, LocalDate> reservation_end);

    void deleteByDriver_LoginName(String id);
}
