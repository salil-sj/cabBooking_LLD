package com.cab.booking.lld.cab.booking.lld;

import com.cab.booking.lld.cab.booking.lld.controller.CabsController;
import com.cab.booking.lld.cab.booking.lld.controller.RideController;
import com.cab.booking.lld.cab.booking.lld.model.Cab;
import com.cab.booking.lld.cab.booking.lld.repository.CabRepository;
import com.cab.booking.lld.cab.booking.lld.repository.DriverRepository;
import com.cab.booking.lld.cab.booking.lld.repository.RiderRepository;
import com.cab.booking.lld.cab.booking.lld.repository.TripRepository;
import com.cab.booking.lld.cab.booking.lld.service.CabService;
import com.cab.booking.lld.cab.booking.lld.service.DriverService;
import com.cab.booking.lld.cab.booking.lld.service.RiderService;
import com.cab.booking.lld.cab.booking.lld.service.TripService;
import com.cab.booking.lld.cab.booking.lld.strategy.CabSearchingStrategy;
import com.cab.booking.lld.cab.booking.lld.strategy.DefaultFareCalculationStrategy;
import com.cab.booking.lld.cab.booking.lld.strategy.FareCalculationStrategy;
import com.cab.booking.lld.cab.booking.lld.strategy.NearestCabSearchingStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CabBookingLldApplicationTests {

	CabsController cabsController;
	RideController rideController;
	CabRepository cabRepository;
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setup(){
		//Repository:
		 cabRepository = new CabRepository();
		DriverRepository driverRepository = new DriverRepository();
		RiderRepository riderRepository = new RiderRepository();
		TripRepository tripRepository= new TripRepository();
		//Service:
		DriverService driverService = new DriverService(driverRepository);
		CabService cabService = new CabService(cabRepository,driverService);
		RiderService riderService= new RiderService(riderRepository);
		//strategies:
		FareCalculationStrategy fareCalculationStrategy= new DefaultFareCalculationStrategy();
		CabSearchingStrategy cabSearchingStrategy= new NearestCabSearchingStrategy();
		TripService tripService= new TripService(fareCalculationStrategy,cabSearchingStrategy,cabService,riderService,tripRepository);
		//controller:
		cabsController=new CabsController(cabService);
		rideController=new RideController(riderService,driverService,tripService);

	}

	@Test
	public void test_one(){
	//1. Register a rider:
		String id1 = rideController.registerRider("Salil");
		String id2 =rideController.registerRider("Ajay");
		String id9 =rideController.registerRider("sonam");
		String id3 =rideController.registerDriver("vijay");
		String id4 =rideController.registerDriver("mohan");

		// register a cab
		String id5=cabsController.registerCab(id3,"UK04AC8646");
		String id6=cabsController.registerCab(id4,"MH12UYY16");

		// UPDATE LOCATION:
		cabsController.updateCabLocation(id5,2.2,5.2);
		cabsController.updateCabLocation(id6,2.2,5.2);
		cabsController.updateCabAvaliability(id5, true);
		cabsController.updateCabAvaliability(id5,true);

		List<Cab> cabs = cabRepository.getAllCabs();
		System.out.println(cabs);

		String rideId = rideController.bookRide(id1,4.1,4.2,5.1,5.1);
		cabs = cabRepository.getAllCabs();
		System.out.println(cabs);
		String rideid2= rideController.bookRide(id2,4.1,4.2,5.1,5.1);
		cabs = cabRepository.getAllCabs();
		System.out.println(cabs);

		//String rideId3= rideController.bookRide(id9,4.1,4.2,5.1,5.1);
		rideController.endTrip(rideId);

		System.out.printf("Getting cabs......");
		cabs = cabRepository.getAllCabs();
		System.out.println(cabs);

		String rideId4= rideController.bookRide(id9,4.1,4.2,5.1,5.1);
		System.out.printf("Ride id4 : %s",rideId4);




	}

}
