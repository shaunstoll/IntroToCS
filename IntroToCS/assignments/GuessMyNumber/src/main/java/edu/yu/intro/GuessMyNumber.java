package edu.yu.intro;

import java.util.Scanner;
import java.util.Random;
public class GuessMyNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final Random random = new Random();
		final int number = random.nextInt(100) + 1;

		System.out.println("I’m thinking of a number between 1 and 100");
		System.out.println("(inclusive).  Can you guess what number it is?");
		System.out.print("Please type a number: ");

		int guessNumber = input.nextInt();
		int difference = guessNumber - number;

		System.out.printf("You guessed <%d>%n", guessNumber);
		System.out.printf("I was thinking of <%d>%n", number);
		System.out.println("You were off by: " + Math.abs(difference));
	}
}
