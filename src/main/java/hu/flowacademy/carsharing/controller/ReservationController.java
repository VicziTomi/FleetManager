package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/allres")
    public ResponseEntity<List<Reservation>> allRes() {
        return ResponseEntity.ok(reservationService.listReservations());
    }

    @GetMapping("/oneres/{id}")
    public ResponseEntity<Reservation> oneRes(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.getOneReservation(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        reservationService.delete(id);
    }
}
