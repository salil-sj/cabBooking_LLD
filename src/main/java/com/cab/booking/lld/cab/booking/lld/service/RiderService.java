package com.cab.booking.lld.cab.booking.lld.service;

import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import com.cab.booking.lld.cab.booking.lld.repository.RiderRepository;

import java.util.UUID;

public class RiderService {

    private RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public String registerRider(String name) {
        String id = UUID.randomUUID().toString();
        Rider rider = new Rider();
        try {
            return riderRepository.save(rider);
        } catch (UserAlreadyExistException exception) {
            return "Error " + exception.getMessage();
        }
    }

    public Rider getRider(String riderId){
        return riderRepository.getById(riderId);
    }
}
