package com.app.cab.driver;

import java.io.IOException;

import com.app.cab.repositories.DriverRepository;
import com.app.cab.repositories.Location;
import com.app.cab.repositories.UserRepository;
import com.app.cab.service.CabServiceImpl;
import com.app.cab.service.DriverServiceImpl;
import com.app.cab.service.UserServiceImpl;

public class Driver {

	public static void main(String[] args) throws IOException {

		CabServiceImpl service = new CabServiceImpl();
		UserServiceImpl uService = new UserServiceImpl();
		DriverServiceImpl dService = new DriverServiceImpl();
		UserRepository uRepo = new UserRepository();
		DriverRepository dRepo = new DriverRepository();
		/**
		 * add_user(name, gender, age)
		 */
		uService.add_user("Abhi", 'M', 23, uRepo);
		
		//verifying user
		System.out.println("User Added : " + uRepo.getuserList().get(0).getName());
		Location u1Loc = new Location(0, 0);
		uService.add_user("user2", 'M', 23, uRepo);
		uService.add_user("user3", 'M', 23, uRepo);
		/**
		 * update_userLocation(Name, X-cords, Y-cords)
		 */
		uService.update_userLocation("Abhi", u1Loc, uRepo);
		//verifying user location
		System.out.println("Update User Loc : (" + uRepo.getuserList().get(0).getX() +","+ uRepo.getuserList().get(0).getY()+")");

		/**
		 * add_driver(name, gender, age, carDetails, location)
		 * Backend : driver_status is set to True;
		 */

		Location d1Loc = new Location(10, 1);
		dService.add_driver("Driver1", 'M', 22, "Swift KA1502", d1Loc, dRepo);
		
		//verifying added driver
		System.out.println("Driver Added : " + dRepo.getDriverList().get(0).getName());
		
		Location src = new Location(0, 2);
		Location des = new Location(5, 4);
		Location outOfReach = new Location(14, 14);
		
		/**
		 * find_ride() : returns nearest driver
		 */
		System.out.println(service.find_ride("Abhi",src, des, dRepo));
		
		/**
		 * find_ride() : returns no Ride found as dist > 5 units
		 */
		System.out.println(service.find_ride("Abhi",outOfReach, des, dRepo));
		
		/**
		 * choose_ride(userName, driverName)
		 */
		System.out.println(service.choose_ride("Abhi", "Driver1"));
		
		/**
		 * calculateBill(userName) : using Euclidean formula
		 */
		System.out.println(service.calculate_bill("Abhi", "Driver1", src, des, uRepo, dRepo));
		
		/**
		 * change_driver_status(userName, status)
		 */
		dService.change_driver_status("Driver1", true, dRepo);
		System.out.println(dRepo.getDriverList().get(0).isAvailable());
		
		/**
		 * find_total_earnings()
		 */
		System.out.println(service.find_total_earning(dRepo));
		
		/**
		 * EXTRA :update_userLocation(Name, X-cords, Y-cords)
		 */
		uRepo.update_userLocation("Abhi", new Location(14, 14));
		System.out.println("Update User Loc : (" + uRepo.getuserList().get(0).getX() +","+ uRepo.getuserList().get(0).getY()+")");

	}
}
