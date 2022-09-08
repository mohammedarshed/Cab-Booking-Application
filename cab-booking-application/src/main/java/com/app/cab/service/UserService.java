package com.app.cab.service;

import com.app.cab.repositories.Location;
import com.app.cab.repositories.UserRepository;

public interface UserService {
	
	public void add_user(final String name, final char gender, final int age, final UserRepository drv);

	public void update_userLocation(String name, Location loc, UserRepository drv);
}
