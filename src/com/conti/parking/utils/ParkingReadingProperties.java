package com.conti.parking.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class ParkingReadingProperties {

	final static String PROP_FILE_NAME = "config.properties";
	final private Properties prop = new Properties();

	public Properties  getPropValues() throws IOException {
		try (InputStream inputStream = loadPropertyFile();) {			
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		return prop;
	}

	private InputStream loadPropertyFile() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + PROP_FILE_NAME + "' not found in the classpath");
		}
		return inputStream;
	}
}
