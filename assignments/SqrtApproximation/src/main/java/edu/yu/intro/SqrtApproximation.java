package edu.yu.intro;

import java.util.Scanner;
public class SqrtApproximation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ‘a‘ -- I will approxiate ‘sqrt(a)‘: ");
		double a = input.nextDouble();
		int iterations = 1;
		double denominator = 2;
		double betterDenominator = (2 + a/2) / 2;
		double difference = Math.abs(2 - betterDenominator);
		double sqrt = Math.sqrt(a);

		if (a < 0.00001) {
			System.out.printf("%n*************************************************%n");
			System.out.printf("sqrt(%.3f)%n", a);
			System.out.println("Error: you must enter a number greater than or equal to 0.00001");
			System.out.printf("*************************************************%n");
			System.exit(0);
		}

		while (difference >= 0.0001) {
			denominator = betterDenominator;
			betterDenominator = (betterDenominator + a/betterDenominator) / 2;
			difference = Math.abs(denominator - betterDenominator);
			iterations++;
		}
		double sqrtDif = Math.abs(sqrt - betterDenominator);
		System.out.printf("%n*************************************************%n");
		System.out.printf("sqrt(%,.3f) = %.3f after %d iteration(s): [difference from Math.sqrt = %.8f]%n", a, betterDenominator, iterations, sqrtDif);
		System.out.println("*************************************************");
	}
}