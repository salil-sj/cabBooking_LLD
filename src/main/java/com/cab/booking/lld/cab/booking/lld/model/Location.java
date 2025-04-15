package com.cab.booking.lld.cab.booking.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Location {
    private Double x;
    private Double y;

    public Double distance(Location location){
        double x1= Math.pow(this.x-location.x,2);
        double x2= Math.pow(this.y-location.y,2);
        return Math.sqrt(x1+x2);
    }

}
