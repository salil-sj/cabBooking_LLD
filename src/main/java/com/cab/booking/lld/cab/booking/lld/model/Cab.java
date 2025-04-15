package com.cab.booking.lld.cab.booking.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Cab {
    private String id;
    private String reg;
    private Driver driver;
    @Setter
    private Trip currentTrip;
    @Setter
    private Location currentLocation;
    @Setter
    private boolean isAvaliable;

    public void assignTrip(Trip trip) {
        this.currentTrip = trip;
        this.isAvaliable = false;
    }

    public void endTrip() {
        this.currentTrip=null;
        this.isAvaliable=true;
    }
}
