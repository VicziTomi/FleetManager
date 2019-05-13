package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver save(Driver driver) { return driverRepository.save(driver); }

}
