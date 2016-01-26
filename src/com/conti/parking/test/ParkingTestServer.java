package com.conti.parking.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class ParkingTestServer implements Runnable {

	public static final String GATE_NAME = "Gate1";

	public static final int DIRECTION = 0;

	HttpURLConnection connection = null;

	public void testApp() {
		try {
			HttpURLConnection connection = testConnection();
			System.out.println("Connection exists");
			createNewEntry();

		} catch (IOException e) {

		}

	}

	private HttpURLConnection testConnection() throws IOException {
		URL url = new URL("http://localhost:8080/parking-app/");
		URLConnection urlConnection = url.openConnection();
		if (urlConnection instanceof HttpURLConnection) {
			return (HttpURLConnection) urlConnection;
		} else {
			System.out.println("Please enter an HTTP URL.");
			return null;
		}
	}

	@Override
	public void run() {
		testApp();

	}

	public void createNewEntry() {
		URL url;
		try {
			int parkingPlaceId = (int) Math.random() % 1000 + 1;
			url = new URL("http://localhost:8080/parking-app/parking/action?gateId=1&parkingPlaceId=15&direction=IN");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");

			urlConnection.setRequestProperty("Content-Type", "application/json");

			String input = "{\"gateId\":1, \"parkingPlaceId\":" + parkingPlaceId + ", \"direction\":" + "\"IN\"" + "}";
			System.out.println(urlConnection.toString());
			OutputStream os = urlConnection.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			System.out.println(os.toString());
			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + urlConnection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			urlConnection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
