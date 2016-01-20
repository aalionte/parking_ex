package com.conti.parking;

import java.io.IOException;

import com.conti.parking.cli.ClientConsole;
import com.conti.parking.utils.ParkingProperties;
import com.conti.parking.utils.ParkingReadingProperties;

public class MainApp {

	public static void main(String[] args) throws IOException {
		ParkingProperties properties = new ParkingProperties();
		properties.setConfiguration(new ParkingReadingProperties().getPropValues());
		new ClientConsole().getClientOption();
	}

}
