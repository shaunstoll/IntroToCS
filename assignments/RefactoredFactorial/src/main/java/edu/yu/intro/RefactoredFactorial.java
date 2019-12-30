package edu.yu.intro;

import java.util.Scanner;

public class RefactoredFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a non-negative integer 'n' -- I will calculate factorial(n): ");
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
		long total = factorial(n);
		System.out.println("*************************************************");
		System.out.printf("factorial(%d) = %,d%n", n, total);
		System.out.println("*************************************************");	
	}

	public static long factorial(int n) {
		if (n < 0) {
			System.out.println("*************************************************");
			throw new IllegalArgumentException("you must enter a non-negative integer.");
		}
		long total = 1;
		for (int i = n; i >= 1; i--) {
			total *= i;
		}
		return total;
	}
}