package com.cab.booking.lld.cab.booking.lld.repository;

import com.cab.booking.lld.cab.booking.lld.exceptions.TripAlreadyExistsException;
import com.cab.booking.lld.cab.booking.lld.exceptions.TripNotFoundException;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import com.cab.booking.lld.cab.booking.lld.model.Trip;
import com.cab.booking.lld.cab.booking.lld.model.TripStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TripRepository {

    private static final Map<String, Trip> trips = new HashMap<>();

    public void save(Trip trip) {
        if (trips.containsKey(trip.getId())) {
            throw new TripAlreadyExistsException("This trip already exists");
        }
        trips.put(trip.getId(), trip);
    }

    public void endTrip(String tripId) {
        if (!trips.containsKey(tripId)) {
            throw new TripNotFoundException("Trip not found");
        }
        Trip ongoingTrip = trips.get(tripId);
        ongoingTrip.endTrip();
        trips.put(tripId, ongoingTrip);
    }

    public List<Trip> getTripHistory(String riderId){
        List<Trip> tripHistory = trips.values().stream().filter(trip->trip.getRider().getId().equals(riderId) && trip.getTripStatus()== TripStatus.COMPLETED).toList();
        return tripHistory;
    }


}
