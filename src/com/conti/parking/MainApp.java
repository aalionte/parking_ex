package com.conti.parking;

import java.io.IOException;
import java.text.ParseException;

import com.conti.parking.cli.ClientConsole;
import com.conti.parking.test.ParkingTestServer;
import com.conti.parking.utils.ParkingReadingProperties;

public class MainApp {

	public static void main(String[] args) throws IOException, ParseException {
		ParkingTestServer thread1 = new ParkingTestServer();
		thread1.run();
		new ParkingTestServer().testApp();
		ParkingReadingProperties properties = new ParkingReadingProperties();
		//new ClientConsole().getClientOption(properties.getPropValues());
	}

}
