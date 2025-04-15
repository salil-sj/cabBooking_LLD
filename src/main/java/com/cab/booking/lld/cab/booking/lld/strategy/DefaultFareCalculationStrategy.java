package com.cab.booking.lld.cab.booking.lld.strategy;

import com.cab.booking.lld.cab.booking.lld.model.Location;

public class DefaultFareCalculationStrategy implements FareCalculationStrategy{

    private static final double FARE_PER_KM = 2;

    @Override
    public Double calculateFare(Location souceLocation, Location destinationLocation) {
        return souceLocation.distance(destinationLocation)*FARE_PER_KM;
    }
}
