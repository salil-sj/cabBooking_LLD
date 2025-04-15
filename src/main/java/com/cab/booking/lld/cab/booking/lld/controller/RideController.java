package com.cab.booking.lld.cab.booking.lld.controller;

import com.cab.booking.lld.cab.booking.lld.model.Trip;
import com.cab.booking.lld.cab.booking.lld.service.DriverService;
import com.cab.booking.lld.cab.booking.lld.service.RiderService;
import com.cab.booking.lld.cab.booking.lld.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class RideController {
    /*
    - register rider POST
    - register driver POST
    - /book POST
    - /getHistory GET
     */
    private RiderService riderService;
    private DriverService driverService;
    private TripService tripService;

    public RideController(RiderService riderService, DriverService driverService, TripService tripService) {
        this.riderService = riderService;
        this.driverService = driverService;
        this.tripService = tripService;
    }

    @PostMapping("register/rider")
    public ResponseEntity<String> registerRider(String name) {
        String id = riderService.registerRider(name);
        return ResponseEntity.ok(id);
    }

    @PostMapping("register/driver")
    public ResponseEntity<String> registerDriver(String name) {
        String id = driverService.registerDriver(name);
        return ResponseEntity.ok(id);
    }

    public ResponseEntity<String> bookRide(String riderId, Double sourceX, Double sourceY, Double destX, Double destY) {
        String id = tripService.bookRide(riderId, sourceX, sourceY, destX, destY);
        return ResponseEntity.ok(id);
    }

    public void endTrip(String tripId) {
        tripService.endTrip(tripId);
    }

    public List<Trip> getTripHistory(String riderId) {
        return tripService.getTripHistory(riderId);
    }
}
