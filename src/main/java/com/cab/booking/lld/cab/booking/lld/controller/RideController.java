package com.cab.booking.lld.cab.booking.lld.controller;

import com.cab.booking.lld.cab.booking.lld.service.DriverService;
import com.cab.booking.lld.cab.booking.lld.service.RiderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class RideController {
   /*
   - register rider POST
   - register driver POST
   - /book POST
   - /getHistory GET
    */
    private RiderService riderService;
    private DriverService driverService;

    public RideController(){
        this.riderService= new RiderService();
        this.driverService= new DriverService();
    }

    @PostMapping("register/rider")
    public ResponseEntity<String> registerRider(String name){
       String id = riderService.registerRider(name);
       return ResponseEntity.ok(id);
    }

    @PostMapping("register/driver")
    public ResponseEntity<String> registerDriver(String name){
        String id = driverService.registerDriver(name);
        return  ResponseEntity.ok(id);
    }
}
