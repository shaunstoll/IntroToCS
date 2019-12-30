package edu.yu.intro;

import java.util.Scanner;
public class FermatsLastTheorem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Fermat Last Theorem checker: Enter (integers) 'a', 'b', 'c', 'n': ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double n = input.nextDouble();
		// double verus integer input check allowing for ending zeros eg. 4.00 ACCEPTED 4.01 ERROR
		double ar = Math.round(a);
		double br = Math.round(b);
		double cr = Math.round(c);
		double nr = Math.round(n);
		// exonentials
		double aExponential = java.lang.Math.pow(a, n);
		double bExponential = java.lang.Math.pow(b, n);
		double cExponential = java.lang.Math.pow(c, n);
		// Input
		System.out.printf("%n********************************************************************%n");
		System.out.println("INPUT ...");
		System.out.printf("   a: %.6f%n", a);
		System.out.printf("   b: %.6f%n", b);
		System.out.printf("   c: %.6f%n", c);
		System.out.printf("(coefficient n): %.6f%n%n", n);

		if (a != ar || b != br|| c != cr || n != nr) {
			System.out.println("Error: Program requires integer input.");
			System.exit(0);
		}
		if (a < 1|| b < 1|| c < 1|| n < 1) {
			System.out.println("Error: all input parameters must be positive integers.");
			System.exit(0);
		}
		// Output
		System.out.println("OUTPUT ...");
		System.out.printf("Evaluating %.0f + %.0f ==? %.0f: ", aExponential, bExponential, cExponential);
		if (n > 2 && aExponential + bExponential == cExponential) {
			System.out.println("true");
			System.out.println("Major discovery: I just proved that Fermat was wrong!");
			System.out.printf("********************************************************************%n");
			System.exit(0);
		}
		if (n > 2 && aExponential + bExponential != cExponential) {
			System.out.println("false");
			System.out.println("Hmmm ... you haven't disproved Fermat's theorem yet.");
			System.out.printf("********************************************************************%n");
			System.exit(0);
		}
		if (n <= 2 && aExponential + bExponential == cExponential) {
			System.out.println("true");
			System.out.println("The sums are equal, but irrelevant to Fermat’s theorem which applies only to n > 2.");
			System.out.printf("********************************************************************%n");
			System.exit(0);
		}	
		if (n <= 2 && aExponential + bExponential != cExponential) {
			System.out.println("false");
			System.out.println("The sums are not equal, but irrelevant to Fermat’s theorem which applies only to n > 2.");
			System.out.printf("********************************************************************%n");
			System.exit(0);
		}	
	}
}