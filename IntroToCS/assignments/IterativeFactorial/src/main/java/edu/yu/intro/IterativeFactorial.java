package edu.yu.intro;

import java.util.Scanner;
public class IterativeFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 'n' -- I will calculate factorial(n): ");
		double n = input.nextDouble();
		long originalN = (long)n;
		long counter = (long)n;
		long total = 1;
		double checker = Math.round(n);

		if (n < 0 || checker != n) {
			System.out.println("*************************************************");
			System.out.println("factorial (" + n + ")");
			System.out.println("Error: you must enter a non-negative integer.");
			System.out.println("*************************************************");
			System.exit(0);
		}

		while (counter >= 1) {
			total *= counter;
			counter--;
		}
		System.out.println("*************************************************");
		System.out.printf("factorial(%d) = %,d%n", originalN, total);
		System.out.println("*************************************************");
	}
}