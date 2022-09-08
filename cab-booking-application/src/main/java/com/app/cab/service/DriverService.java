package com.app.cab.service;

import com.app.cab.repositories.DriverRepository;
import com.app.cab.repositories.Location;

public interface DriverService {
	public void change_driver_status(String name, Boolean b, DriverRepository dRepo);

	public void add_driver(final String name, final char gender, final int age, final String car, final Location loc,
			final DriverRepository drv);

}
