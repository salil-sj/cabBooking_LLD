package com.cab.booking.lld.cab.booking.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public abstract class User {
    private String id;
    private String name;
    //...

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
