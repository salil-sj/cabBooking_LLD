package com.cab.booking.lld.cab.booking.lld.service;

import com.cab.booking.lld.cab.booking.lld.exceptions.NoCabDoundException;
import com.cab.booking.lld.cab.booking.lld.model.Cab;
import com.cab.booking.lld.cab.booking.lld.model.Location;
import com.cab.booking.lld.cab.booking.lld.model.Rider;
import com.cab.booking.lld.cab.booking.lld.model.Trip;
import com.cab.booking.lld.cab.booking.lld.repository.TripRepository;
import com.cab.booking.lld.cab.booking.lld.strategy.CabSearchingStrategy;
import com.cab.booking.lld.cab.booking.lld.strategy.FareCalculationStrategy;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class TripService {

    private FareCalculationStrategy fareCalculationStrategy;
    private CabSearchingStrategy cabSearchingStrategy;
    private CabService cabService;
    private RiderService riderService;
    private TripRepository tripRepository;

    public TripService(FareCalculationStrategy fareCalculationStrategy,
                CabSearchingStrategy cabSearchingStrategy,
                CabService cabService,
                RiderService riderService,
                TripRepository tripRepository){
        this.fareCalculationStrategy= fareCalculationStrategy;
        this.cabSearchingStrategy= cabSearchingStrategy;
        this.cabService= cabService;
        this.riderService=riderService;
        this.tripRepository= tripRepository;
    }

    public String bookRide(String riderId, Double sourceX, Double sourceY, Double destX, Double destY){

        Location sourceLocation = new Location(sourceX,sourceY);
        Location destinationLocation = new Location(destX,destY);
        double fare = fareCalculationStrategy.calculateFare(sourceLocation, destinationLocation);
        Rider rider = riderService.getRider(riderId);
        Cab assignedCab = cabSearchingStrategy.getCab(cabService.getAvaliableCabs(),sourceLocation,destinationLocation);
        if(assignedCab == null){
            throw new NoCabDoundException("No Cab found");
        }
        String tripId = UUID.randomUUID().toString();
        Trip trip= new Trip(tripId,rider,fare, sourceLocation,destinationLocation,assignedCab);
        assignedCab.assignTrip(trip);
        tripRepository.save(trip);
        return tripId;
    }

    public void endTrip(String tripId){
        Trip trip = tripRepository.findById(tripId);
        tripRepository.endTrip(tripId);
        cabService.updateCabAvaliability(trip.getCab().getId(),true);

    }

    public List<Trip> getTripHistory(String riderId){
        return tripRepository.getTripHistory(riderId);
    }
}
