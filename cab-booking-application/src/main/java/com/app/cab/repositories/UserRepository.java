package com.app.cab.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

	private List<User> userList;

	public UserRepository() {
		this.userList = new ArrayList<>();
	}

	public List<User> getuserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void add_user(User user) {
		this.userList.add(user);
	}

	public void update_user(String name, User user) {
		this.userList = userList.parallelStream().filter(x -> x.getName().equals(name)).map(x -> modifyUser(user))
				.collect(Collectors.toList());
	}

	public void update_userLocation(String name, Location loc) {
		this.userList = userList.parallelStream().filter(x -> x.getName().equals(name))
				.map(x -> modifyLocation(x, loc)).collect(Collectors.toList());
	}

	private User modifyUser(User newUser) {
		return newUser;
	}

	private User modifyLocation(User user, Location loc) {
		user.setX(loc.getX());
		user.setY(loc.getY());
		return user;
	}

}
