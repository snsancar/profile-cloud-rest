package com.apsis.profile.model;

/**
 * Model class used to hold the Counter Name and corresponding Value.
 * @author sankar
 *
 */
public class Counter {

	private String counterName;
	private int value;

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
