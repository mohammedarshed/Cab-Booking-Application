package com.app.cab.repositories;

//import lombok.AllArgsConstructor;

//@Getter
//@Setter
//@AllArgsConstructor
public class CabDriver extends User {
	private String carNumber;

	private int earnings;

	private boolean status;

	public boolean isAvailable() {
		return status;
	}

	public void setAvailable(boolean status) {
		this.status = status;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public CabDriver(final String name, final char gender, final int age, final String carNumber) {
		super(name, gender, age);
		this.carNumber = carNumber;
		this.status = true;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
}
