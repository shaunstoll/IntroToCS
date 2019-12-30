package edu.yu.intro;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class InterfacedQuizGenerator {
	
	public static void main(String[] args) {
		IntQuestion[] myQuiz = new IntQuestion[10];
		createQuiz(myQuiz);
		int[] userAnswers = new int[myQuiz.length];
		administerQuiz(myQuiz, userAnswers);
		gradeQuiz(myQuiz, userAnswers);
	}

	public static void createQuiz(IntQuestion[] quiz) {
		for (int i = 0; i < quiz.length; i++) {
			Random random = new Random();
			boolean randomBoolean = random.nextBoolean();
			if (randomBoolean == true) {quiz[i] = new AdditionQuestion();}
			else {quiz[i] = new SubtractionQuestion();}
		}
	}
	
	public static void administerQuiz(IntQuestion[] quiz, int[] myAnswers) {
		Scanner input = new Scanner(System.in);
		int questionNumber = 1;
		System.out.println("*************************************");
		System.out.printf("Welcome to the addition integer arithmetic quiz!%n%n");
		
		for (int i = 0; i < quiz.length; i++) {
			System.out.print("Question " + questionNumber++ + ": " + quiz[i].getQuestion());

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

	public static void gradeQuiz(IntQuestion[] quiz, int[] myAnswers) {
		int totalCorrect = 0;
		int questionNumber = 1;

		System.out.printf("%nHere are the correct answers:%n");

		for (int i = 0; i < quiz.length; i++) {
			System.out.print("Question " + questionNumber++ + ": " + quiz[i].getQuestion() + " Correct answer is " + quiz[i].getCorrectAnswer());

			if (myAnswers[i] == quiz[i].getCorrectAnswer()) {
				totalCorrect++;
				System.out.println("  You were CORRECT.");
			}
			else {
				System.out.printf("  You said %d, which is INCORRECT.%n", myAnswers[i]);
			}	
		}
		System.out.printf("%nYou got %d question(s) correct.%n", totalCorrect);
		System.out.println("Your grade on the quiz is " + totalCorrect*10);
		System.out.println("*************************************");
	}
}