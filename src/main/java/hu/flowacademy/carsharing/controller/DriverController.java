package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.save(driver));
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<Driver> getOneDriver(@PathVariable String id) {
        return ResponseEntity.ok(driverService.getOneDriver(id));
    }

    @GetMapping("/alldrivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.listDrivers());
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        driverService.delete(id);
    }

    @DeleteMapping("validdelete/{id}")
    public void validDelete(@PathVariable String id) {
        driverService.validDelete(id);
    }

}
