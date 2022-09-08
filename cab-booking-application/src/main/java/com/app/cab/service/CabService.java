package com.app.cab.service;

import java.util.List;

import com.app.cab.repositories.CabDriver;
import com.app.cab.repositories.DriverRepository;
import com.app.cab.repositories.Location;
import com.app.cab.repositories.UserRepository;

public interface CabService {
	
	public List<String> find_ride(String name, Location src, Location des, DriverRepository dRepo);

	public List<CabDriver> find_nearestDrivers(String name, Location src, List<CabDriver> drv);

	public String choose_ride(String user, String driver);
	
	public int calculate_bill(String userName, String driverName, Location src, Location dest, UserRepository urv,
			DriverRepository drv);
	
	public List<String> find_total_earning(DriverRepository drv);
	
}
