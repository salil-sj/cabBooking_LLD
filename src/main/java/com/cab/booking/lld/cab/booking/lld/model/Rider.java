package com.cab.booking.lld.cab.booking.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
public class Rider extends User{
    public Rider(String id, String name) {
        super(id,name);
    }
}
