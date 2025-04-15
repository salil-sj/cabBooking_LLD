package com.cab.booking.lld.cab.booking.lld.strategy;

import com.cab.booking.lld.cab.booking.lld.model.Location;

public interface FareCalculationStrategy {
    public Double calculateFare(Location souceLocation, Location destinationLocation);
}
