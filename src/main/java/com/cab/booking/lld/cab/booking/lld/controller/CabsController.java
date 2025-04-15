package com.cab.booking.lld.cab.booking.lld.controller;

import com.cab.booking.lld.cab.booking.lld.model.Location;
import com.cab.booking.lld.cab.booking.lld.service.CabService;
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

    private CabService cabService;

    public CabsController() {
        this.cabService = new CabService();
    }

    @PostMapping("/register/cab")
    public ResponseEntity<String> registerCab(String driverId, String reg) {
        String id = cabService.registerCab(driverId, reg);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/update/location")
    public void updateCabLocation(String cabId, Location location) {
        cabService.updateCabLocation(cabId,location);
    }

    @PostMapping("/update/avaliability")
    public void updateCabAvaliability(String cabId, boolean isAvaliable){
        cabService.updateCabAvaliability(cabId,isAvaliable);
    }


}
