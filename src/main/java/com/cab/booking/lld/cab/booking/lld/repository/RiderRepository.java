package com.cab.booking.lld.cab.booking.lld.repository;

import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RiderRepository {

    private static final Map<String, Rider> riders = new HashMap();

    public String save(@NonNull  Rider rider){
        if(riders.get(rider)!=null){
            throw new UserAlreadyExistException("Sorry this user already exists");
        }
        riders.put(rider.getId(), rider);
        return rider.getId();
    }

    public Rider getById(String id){
        return riders.get(id);
    }

}
