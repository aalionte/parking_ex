package com.conti.parking.utils;

import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Enumeration;

public class ParkingProperties {

	private int noGates;
	private List<String> nameOfGates = new ArrayList<>();

	private enum Direction {
		IN, OUT
	};

	private int parkingNo;
	private int carsInterval;

	public int getNoGates() {
		return noGates;
	}

	public void setNoGates(int noGates) {
		this.noGates = noGates;
	}

	public List<String> getNameOfGates() {
		return nameOfGates;
	}

	public void setNameOfGates(List<String> nameOfGates) {
		this.nameOfGates = nameOfGates;
	}

	public int getCarsInterval() {
		return carsInterval;
	}

	public void setCarsInterval(int carsInterval) {
		this.carsInterval = carsInterval;
	}

	public int getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(int parkingNo) {
		this.parkingNo = parkingNo;
	}

	public void setConfiguration(Properties prop) {
		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			if (key.contains("gates.no")) {
				noGates = Integer.parseInt(value);
			}
			if (key.contains("gates.name")) {
				nameOfGates.add(value);
			}
			if (key.contains("places.no")) {
				parkingNo = Integer.parseInt(value);
			}
			System.out.println("Key : " + key + ", Value : " + value);
		}

	}

}
