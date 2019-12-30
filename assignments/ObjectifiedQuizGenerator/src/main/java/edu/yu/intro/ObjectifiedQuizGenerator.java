package edu.yu.intro;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ObjectifiedQuizGenerator {

	public static void main(String[] args) {
		AdditionQuestion[] myQuiz = new AdditionQuestion[10];
		int[] userAnswers = new int[myQuiz.length];
		createQuiz(myQuiz);
		administerQuiz(myQuiz, userAnswers);
		gradeQuiz(myQuiz, userAnswers);
	}

	public static void createQuiz(AdditionQuestion[] quiz) {
		for (int i = 0; i < quiz.length; i++) {
			quiz[i] = new AdditionQuestion();
		}
	}
	
	public static void administerQuiz(AdditionQuestion[] quiz, int[] myAnswers) {
		Scanner input = new Scanner(System.in);
		System.out.println("*************************************");
		System.out.printf("Welcome to the addition quiz!%n%n");
		for (int i = 0; i < quiz.length; i++) {
			System.out.print(quiz[i].getQuestion());

			try {
				myAnswers[i] = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println();
				System.out.println("Error: " + e);
				System.out.println("You must enter an integer.");
				System.out.println("*************************************");
				System.exit(0);
			}
		}
	}	

	public static void gradeQuiz(AdditionQuestion[] quiz, int[] myAnswers) {
		int totalCorrect = 0;

		System.out.printf("%nHere are the correct answers:%n");

		for (int i = 0; i < quiz.length; i++) {
			if (myAnswers[i] == quiz[i].getCorrectAnswer()) {
				totalCorrect++;
				System.out.print(quiz[i].getQuestion());
				System.out.print(quiz[i].getCorrectAnswer());
				System.out.println("     You were CORRECT.");
			}
			else {
				System.out.print(quiz[i].getQuestion());
				System.out.print(quiz[i].getCorrectAnswer());
				System.out.printf("     You said %d, which is INCORRECT.%n", myAnswers[i]);
			}	
		}
		System.out.printf("%nYou got %d question(s) correct.%n", totalCorrect);
		System.out.println("Your grade on the quiz is " + totalCorrect*10);
		System.out.println("*************************************");
	}
}