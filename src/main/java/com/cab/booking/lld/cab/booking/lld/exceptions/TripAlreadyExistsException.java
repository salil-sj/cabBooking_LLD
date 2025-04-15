package com.cab.booking.lld.cab.booking.lld.exceptions;

public class TripAlreadyExistsException extends RuntimeException {
    public TripAlreadyExistsException(String message) {
        super(message);
    }
}
