package com.cab.booking.lld.cab.booking.lld.service;

import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Driver;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import com.cab.booking.lld.cab.booking.lld.repository.DriverRepository;

import java.util.UUID;

public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String registerDriver(String name) {
        String id = UUID.randomUUID().toString();
        Driver rider = new Driver(id,name);
        try {
            return driverRepository.save(rider);
        } catch (UserAlreadyExistException exception) {
            return "Error " + exception.getMessage();
        }
    }

    public Driver getDriverById(String driverId){
        return driverRepository.getById(driverId);
    }
}
