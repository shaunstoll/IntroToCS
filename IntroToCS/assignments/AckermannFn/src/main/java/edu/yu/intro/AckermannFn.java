package edu.yu.intro;

import java.util.Scanner;
import java.util.InputMismatchException;
public class AckermannFn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("*****************************************");
			System.out.println("I will use Ackermann's Function A(m, n).");
			System.out.print("Enter m: ");
			long m = input.nextLong();
			System.out.print("Enter n: ");
			long n = input.nextLong();
			long result = ackermann(m, n);
			System.out.printf("A(%d, %d) = %d%n", m, n, result);
			System.out.println("*****************************************");
		}
		catch (InputMismatchException e){
			System.err.println("Error: " + e);
			System.out.println("You must enter non-negative integers.");
			System.out.println("*****************************************");
		}
	}

	public static long ackermann(long m, long n) {
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException("Error: You must enter a non-negative number.");
		}
		if (m == 0) {
			return n + 1L;
		}
		else if (n == 0) {
			return ackermann(m - 1L, 1L);
		}
		else {
			return ackermann(m - 1L, ackermann(m, n - 1L));
		}
	}
}