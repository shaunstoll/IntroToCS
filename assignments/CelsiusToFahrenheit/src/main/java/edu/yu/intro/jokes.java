package edu.yu.intro; 

import java.util.Scanner;
public class jokes {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.print("Enter temperature in Celsius: ");
	double valueCelsius = input.nextDouble();

	double result = (valueCelsius * 9/5) + 32;
	System.out.printf("%.1f°C = %.1f°F%n", valueCelsius, result);
	}
}