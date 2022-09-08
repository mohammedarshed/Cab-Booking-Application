package com.app.cab.service;

import com.app.cab.repositories.Location;
import com.app.cab.repositories.User;
import com.app.cab.repositories.UserRepository;

public class UserServiceImpl implements UserService{

	@Override
	public void add_user(final String name, final char gender, final int age, final UserRepository drv) {
		User usr = new User(name, gender, age);
		drv.add_user(usr);
	}
	
	@Override
	public void update_userLocation(String name, Location loc, UserRepository drv) {
		drv.update_userLocation(name, loc);
	}
	
}
