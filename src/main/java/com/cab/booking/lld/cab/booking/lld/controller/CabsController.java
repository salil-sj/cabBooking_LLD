package com.cab.booking.lld.cab.booking.lld.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
     /*
    -/register/cab POST
    -/update/cab/location POST
    -update/cab/avaliability POST
    -update/cab/endTrip POST
     */
    @PostMapping("/register/cab")
    public ResponseEntity<String> registerCab( ){

    }
}
