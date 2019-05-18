package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/res")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addRes(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @PostMapping("validateadd/{id}")
    public ResponseEntity<Reservation> validateAdd(@RequestBody Reservation reservation, @PathVariable String id) {
        return ResponseEntity.ok(reservationService.validatedSave(reservation, id));
    }

    @GetMapping("/allres")
    public ResponseEntity<List<Reservation>> allRes() {
        return ResponseEntity.ok(reservationService.listReservations());
    }

    @GetMapping("/oneres/{id}")
    public ResponseEntity<Reservation> oneRes(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.getOneReservation(id));
    }

    @GetMapping("res-by-driver/{driver}")
    public ResponseEntity<List<Reservation>> listByDriver(@PathVariable String driver) {
        return ResponseEntity.ok(reservationService.listByDriver(driver));
    }

    @GetMapping("res-by-car/{platenumber}")
    public ResponseEntity<List<Reservation>> listByCar(@PathVariable String platenumber) {
        return ResponseEntity.ok(reservationService.listByCar(platenumber));
    }

    @GetMapping("res-by-period")
    public ResponseEntity<List<Reservation>> listByPeriod(@RequestBody HashMap start, HashMap end) {
        return ResponseEntity.ok(reservationService.listByPeriod(start, end));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        reservationService.delete(id);
    }

    @GetMapping("/resbycar/{id}")
    public ResponseEntity<List<Reservation>> resByCar(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.listReservationsById(id));
    }
}
