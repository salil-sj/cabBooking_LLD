package com.cab.booking.lld.cab.booking.lld.repository;

import com.cab.booking.lld.cab.booking.lld.exceptions.NoUserFoundException;
import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Driver;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class DriverRepository {

    private static final Map<String, Driver> drivers = new HashMap<>();

    public String save(@NonNull Driver driver){
        if(drivers.containsKey(driver.getId())){
            throw new UserAlreadyExistException("Sorry, user is already present!");
        }
        return drivers.put(driver.getId(), driver).getId();
    }

   public Driver getById(String id){
        if(!drivers.containsKey(id)){
            throw new NoUserFoundException("No driver with id :"+ id);
        }
        return drivers.get(id);
   }
}
