package edu.yu.intro;

import java.util.Scanner;
public class JUnit4SqrtApproximation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ‘n‘ -- I will calculate all square roots from 0 to n (inclusive) using Babylonian approximation algorithm: ");
		int n = 0;
		try {
			n = input.nextInt();
		}
		catch (java.util.InputMismatchException e){
			System.out.println("*************************************************");
			System.out.println("Error: You must enter a non-negatvie integer");
			System.out.println("*************************************************");
			System.exit(0);
		}
		double[] results = calculateSquareRoots(n);
		System.out.println("*************************************************");
		for (int i = 0; i <= n; i++) {
			System.out.printf("sqrt(%d) = %.3f%n", i, results[i]);
		}
		System.out.println("*************************************************");
	}
	// babylonian square root
	public static double sqrt(double a) {

		if (a < 0) {
			System.out.println("*************************************************");
			throw new IllegalArgumentException("you must enter a non-negative number.");
		}
		double denominator = 2;
		double betterDenominator = (2 + a/2) / 2;
		double difference = Math.abs(2 - betterDenominator);
		double sqrtValue = betterDenominator;

		if (a == 0) {
			sqrtValue = 0;
		}
		while (difference >= 0.0001 && a != 0) {
			denominator = betterDenominator;
			betterDenominator = (betterDenominator + a/betterDenominator) / 2;
			difference = Math.abs(denominator - betterDenominator);
			sqrtValue = betterDenominator;
		}
		return sqrtValue;
	}
	// 0 to n square rooter
	public static double[] calculateSquareRoots(int n) {
			if (n < 0) {
			System.out.println("*************************************************");
			throw new IllegalArgumentException("you must enter a non-negative number.");
		}

		double[] intSqrts = new double[n + 1];
		for (int i = 0; i <= n; i++) {
				intSqrts[i] = sqrt(i);
		}
		return intSqrts;
	}
}