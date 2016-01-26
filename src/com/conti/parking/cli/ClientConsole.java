package com.conti.parking.cli;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.conti.parking.utils.ParkingPropertiesUtil;

public class ClientConsole {

	int gateNumber;

	int choice = -1;
	int direction;

	public void getClientOption(Properties properties) throws ParseException {
		final ParkingPropertiesUtil propUtil = new ParkingPropertiesUtil(properties);
		System.out.println("Please select one of the options below:");
		System.out.println("A - For choosing the gate number or name, as desired");
		System.out.println("B - for choosing the direction IN or OUT");
		System.out.println("C - for choosing the number of cars which are using the parking");
		System.out.println("D - for choosing the input cars interval");
		System.out.println("E - exit menu");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		option = (option.equals(option.toLowerCase())) ? option.toUpperCase() : option;
		switch (option) {
		case "A": {
			List<String> gateProperties = propUtil.getAllGateList();
			getGateNumber(gateProperties);
		}
			break;
		case "B":

			break;
		default:

		}
		scanner.close();
	}

	@SuppressWarnings("resource")
	private void getGateNumber(List<String> gateProperties) throws ParseException {
		int i = 0;
		for (String gateName : gateProperties) {
			System.out.println("For gate " + gateName + " press " + i++);
		}
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (!(choice >= 0 && choice < gateProperties.size())) {
			choice = (int) Math.random() % gateProperties.size();

		}
	}

}
