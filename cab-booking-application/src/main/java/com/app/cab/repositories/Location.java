package com.app.cab.repositories;

//import lombok.AllArgsConstructor;

//@Getter
//@Setter
//@AllArgsConstructor
public class Location {
	private int xCoordinates;
	private int yCoordinates;

	public Location(int x, int y) {
		this.xCoordinates = x;
		this.yCoordinates = y;
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return xCoordinates;
	}

	public void setX(int xCoordinates) {
		this.xCoordinates = xCoordinates;
	}

	public int getY() {
		return yCoordinates;
	}

	public void setY(int yCoordinates) {
		this.yCoordinates = yCoordinates;
	}

	public void updateLocation(final int xCoordinates, final int yCoordinates) {
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
	}
}