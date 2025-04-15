package com.cab.booking.lld.cab.booking.lld.controller;

import com.cab.booking.lld.cab.booking.lld.model.Location;
import com.cab.booking.lld.cab.booking.lld.service.CabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


public class CabsController {

    private CabService cabService;

    public CabsController(CabService cabService) {
        this.cabService = cabService;
    }


    public String registerCab(String driverId, String reg) {
        String id = cabService.registerCab(reg,driverId);
        return id;
    }


    public void updateCabLocation(String cabId, Double x , Double y ) {
        cabService.updateCabLocation(cabId,x,y);
    }


    public void updateCabAvaliability(String cabId, boolean isAvaliable){
        cabService.updateCabAvaliability(cabId,isAvaliable);
    }


}
