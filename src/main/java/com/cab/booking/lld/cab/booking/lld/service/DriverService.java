package com.cab.booking.lld.cab.booking.lld.service;

import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Driver;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import com.cab.booking.lld.cab.booking.lld.repository.DriverRepository;

import java.util.UUID;

public class DriverService {

    private DriverRepository driverRepository;

    public DriverService() {
        this.driverRepository = new DriverRepository();
    }

    public String registerDriver(String name) {
        String id = UUID.randomUUID().toString();
        Driver rider = new Driver();
        try {
            return driverRepository.save(rider);
        } catch (UserAlreadyExistException exception) {
            return "Error " + exception.getMessage();
        }
    }

    public Driver getDriverById(String driverId){

    }
}
