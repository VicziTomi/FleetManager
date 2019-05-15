package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.exception.DriverNotFoundException;
import hu.flowacademy.carsharing.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver save(Driver driver) { return driverRepository.save(driver); }

    public void delete(String id) {
        try {
            driverRepository.deleteById(id);
        } catch (DriverNotFoundException e) {
            e.getMessage();
        }
    }

    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    public Driver getOneDriver(String id) {
        if(driverRepository.findById(id).isPresent()) {
            return driverRepository.findById(id).get();
        }
        throw new DriverNotFoundException(id);
    }

}
