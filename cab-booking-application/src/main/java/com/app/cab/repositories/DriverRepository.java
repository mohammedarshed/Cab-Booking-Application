package com.app.cab.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverRepository {

	private List<CabDriver> driverList;

	public DriverRepository() {
		this.driverList = new ArrayList<>();
	}

	public void setdriverList(List<CabDriver> driverList) {
		this.driverList = driverList;
	}

	public void add_driver(CabDriver user) {
		this.driverList.add(user);
	}

	public void update_Driver(String name, CabDriver user) {
		this.driverList = driverList.parallelStream().filter(x -> x.getName().equals(name)).map(x -> modifyDriver(user))
				.collect(Collectors.toList());
	}

	public void update_driverLocation(String name, Location loc) {
		this.driverList = driverList.parallelStream().filter(x -> x.getName().equals(name))
				.map(x -> modifyLocation(x, loc)).collect(Collectors.toList());
	}

	public void update_driverEarnings(String name, int earnings) {
		this.driverList = driverList.parallelStream().filter(x -> x.getName().equals(name))
				.map(x -> updateEarnings(x, earnings)).collect(Collectors.toList());
	}

	public List<String> getTotalEarnings() {
		return driverList.parallelStream().map(x -> String.valueOf(x.getEarnings())).collect(Collectors.toList());
	}

	public List<CabDriver> getDriverList() {
		return driverList;
	}

	public List<String> getdriverNamesList() {
		return driverList.parallelStream().map(x -> x.getName()).collect(Collectors.toList());
	}

	private CabDriver modifyDriver(CabDriver newDriver) {
		return newDriver;
	}

	private CabDriver updateEarnings(CabDriver driver, int earnings) {
		driver.setEarnings(driver.getEarnings() + earnings);
		return driver;
	}

	private CabDriver modifyLocation(CabDriver user, Location loc) {
		user.setX(loc.getX());
		user.setY(loc.getY());
		return user;
	}
	
	public void change_DriverStatus(String name, Boolean status) {
		this.driverList = driverList.parallelStream().filter(x -> x.getName().equals(name)).map(x -> switchStatus(x,status))
				.collect(Collectors.toList());
	}
	
	public CabDriver switchStatus(CabDriver driver, Boolean status ) {
		driver.setAvailable(status);
		return driver;
	}
}
