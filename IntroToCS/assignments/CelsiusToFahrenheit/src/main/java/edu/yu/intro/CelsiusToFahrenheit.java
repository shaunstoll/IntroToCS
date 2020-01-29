package edu.yu.intro; 

import java.util.Scanner;

public class CelsiusToFahrenheit {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.print("Enter temperature in Celsius: ");
	double valueCelsius = input.nextDouble();

	double result = valueCelsius * 9/5 + 32;
	System.out.printf("%.1f", valueCelsius);
	System.out.print("°C = ");
	System.out.printf("%.1f", result);
	System.out.println("°F");
	}
}