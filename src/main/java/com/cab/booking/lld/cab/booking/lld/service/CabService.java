package com.cab.booking.lld.cab.booking.lld.service;

import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Cab;
import com.cab.booking.lld.cab.booking.lld.model.Driver;
import com.cab.booking.lld.cab.booking.lld.model.Location;
import com.cab.booking.lld.cab.booking.lld.repository.CabRepository;

import java.util.List;
import java.util.UUID;

public class CabService {

    private CabRepository cabRepository;
    private DriverService driverService;

    public CabService(){
        this.cabRepository=new CabRepository();
        this.driverService= new DriverService();
    }

    public String registerCab(String reg, String driverId ) {
        String id = UUID.randomUUID().toString();
        Driver driver= driverService.getDriverById(driverId);
        Cab cab = new Cab(id,reg, driver,null,null,true);
        try {
            return cabRepository.save(cab);
        } catch (UserAlreadyExistException exception) {
            return "Error " + exception.getMessage();
        }
    }

    public void updateCabLocation(String cabId, Location location){
        Cab cab = getCabDetails(cabId);
        cab.setCurrentLocation(location);
    }

    public List<Cab> getAvaliableCabs(){
        return cabRepository.getAvaliableCabs();
    }

    private Cab getCabDetails(String cabId){
        return cabRepository.findById(cabId);
    }

    public void updateCabAvaliability(String cabId, boolean isAvaliable){
        Cab cab = cabRepository.findById(cabId);
        cab.setAvaliable(isAvaliable);
    }
}
