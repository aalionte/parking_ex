package com.conti.parking.utils;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class ParkingPropertiesUtil {

	private Properties props;

	public ParkingPropertiesUtil(Properties props) {
		this.props = props;
	}

	private enum Direction {
		IN, OUT
	};

	private int parkingNo;
	private int carsInterval;

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

	public List<String> getAllGateList() {
		List<String> gatesList = new ArrayList<>();
		Enumeration<?> e = props.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = props.getProperty(key);
			if (key.contains("gates.name")) {
				gatesList.add(value);
			}
			System.out.println("Key : " + key + ", Value : " + value);

		}
		return gatesList;
	}

}
