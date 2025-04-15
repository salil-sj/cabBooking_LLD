package com.cab.booking.lld.cab.booking.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Driver extends User{
    public Driver(String id, String name) {
        super(id,name);
    }
}
