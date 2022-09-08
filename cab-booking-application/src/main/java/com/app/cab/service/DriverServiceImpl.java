package com.app.cab.service;

import com.app.cab.repositories.CabDriver;
import com.app.cab.repositories.DriverRepository;
import com.app.cab.repositories.Location;

public class DriverServiceImpl implements DriverService{

	@Override
	public void change_driver_status(String name, Boolean b, DriverRepository dRepo) {
		dRepo.change_DriverStatus(name, b);
	}
	
	@Override
	public void add_driver(final String name, final char gender, final int age, final String car, final Location loc,
			final DriverRepository drv) {
		CabDriver usr = new CabDriver(name, gender, age, car);
		drv.add_driver(usr);
	}
	
}
