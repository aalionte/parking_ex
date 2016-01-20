package com.conti.parking.cli;

import java.util.Scanner;

public class ClientConsole {

	public void getClientOption() {
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
		case "A":
			getGateNumber();
			break;
		case "B":
			break;
		default:

		}
		scanner.close();
	}

	private void getGateNumber() {
		
	}
}
