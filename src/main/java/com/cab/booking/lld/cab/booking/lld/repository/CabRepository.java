package com.cab.booking.lld.cab.booking.lld.repository;

import com.cab.booking.lld.cab.booking.lld.exceptions.NoCabDoundException;
import com.cab.booking.lld.cab.booking.lld.exceptions.UserAlreadyExistException;
import com.cab.booking.lld.cab.booking.lld.model.Cab;
import com.cab.booking.lld.cab.booking.lld.model.Driver;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabRepository {

    private static final Map<String, Cab> cabs = new HashMap<>();

    public String save(@NonNull Cab cab){
        if(cabs.containsKey(cab.getId())){
            throw new UserAlreadyExistException("Sorry, user is already present!");
        }
        cabs.put(cab.getId(), cab);
        return cab.getId();
    }

    public Cab findById(String id){
        if(!cabs.containsKey(id)){
            throw new NoCabDoundException("No can with id: "+ id+ " :found");
        }
        return cabs.get(id);
    }

    public List<Cab> getAvaliableCabs(){
       return cabs.values().stream().filter(Cab::isAvaliable).collect(Collectors.toList());
    }
    public  List<Cab> getAllCabs(){
        return cabs.values().stream().toList();
    }

}
