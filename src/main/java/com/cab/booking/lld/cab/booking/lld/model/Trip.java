package com.cab.booking.lld.cab.booking.lld.model;

import lombok.Getter;



@Getter
public class Trip {
    private String id;
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(String id, Rider rider, Double price, Location fromPoint, Location toPoint, Cab cab) {
        this.id = id;
        this.rider = rider;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.cab = cab;
        this.tripStatus=TripStatus.IN_PROGRESS;
    }

    public void endTrip(){
        this.tripStatus=TripStatus.COMPLETED;

    }
}
