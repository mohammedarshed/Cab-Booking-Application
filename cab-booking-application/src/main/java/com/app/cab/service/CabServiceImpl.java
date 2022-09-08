package com.app.cab.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.app.cab.repositories.CabDriver;
import com.app.cab.repositories.DriverRepository;
import com.app.cab.repositories.Location;
import com.app.cab.repositories.UserRepository;

public class CabServiceImpl implements CabService {

	public static final String RIDE_STARTED = "Ride Started";

	public static final String NO_RIDE_FOUND = "No Ride Found";

	/**
	 * find_ride gives list of available drivers within 5 units & status = true
	 */
	@Override
	public List<String> find_ride(String name, Location src, Location des, DriverRepository dRepo) {
		List<CabDriver> drv = dRepo.getDriverList();
		List<CabDriver> list = find_nearestDrivers(name, src, drv);
		if (list.isEmpty())
			return Arrays.asList(NO_RIDE_FOUND);
		return list.stream().map(x -> x.getName()).collect(Collectors.toList());
	}

	/**
	 * Source is not required, we can get it from UserRepo(not implemented here)
	 */
	@Override
	public List<CabDriver> find_nearestDrivers(String name, Location src, List<CabDriver> drv) {

		List<CabDriver> ridersAvailable = new ArrayList<>();
		for (CabDriver x : drv) {
			if (calculateDistance(src, new Location(x.getX(), x.getY())) <= 5 && x.isAvailable()) {
				ridersAvailable.add(x);
			}
		}
		return ridersAvailable;
	}

	@Override
	public String choose_ride(String user, String driver) {
		return RIDE_STARTED;
	}

	@Override
	public int calculate_bill(String userName, String driverName, Location src, Location dest, UserRepository urv,
			DriverRepository drv) {

		int fare = Math.abs(calculateDistance(src, dest));
		urv.update_userLocation(userName, dest);
		drv.update_driverEarnings(driverName, fare);
		drv.update_driverLocation(driverName, dest);
		return fare;
	}

	@Override
	public List<String> find_total_earning(DriverRepository drv) {
		List<String> earnings = new ArrayList<>();
		List<String> names = drv.getdriverNamesList();
		List<String> res = drv.getTotalEarnings();
		for (int i = 0; i < names.size(); i++) {
			earnings.add(names.get(i) + " " + res.get(i));
		}
		return earnings;
	}

	public int calculateDistance(Location src, Location des) {
		/*
		 * Euclidean Distance formula
		 */
		return (int) Math.sqrt(Math.pow(des.getY() - src.getY(), 2) + Math.pow(des.getX() - src.getX(), 2));
	}
}
