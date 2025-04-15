package com.cab.booking.lld.cab.booking.lld.strategy;

import com.cab.booking.lld.cab.booking.lld.model.Cab;
import com.cab.booking.lld.cab.booking.lld.model.Location;
import com.cab.booking.lld.cab.booking.lld.repository.CabRepository;

import java.util.List;

public class NearestCabSearchingStrategy implements CabSearchingStrategy {

    @Override
    public Cab getCab(List<Cab> avaliableCabs, Location souceLocation, Location destinationLocation) {
        if (avaliableCabs.isEmpty()) {
            return null;
        }
        return avaliableCabs.get(0);
    }
}
