package edu.yu.intro;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class StaticQuizGenerator {

	public final static int N_QUIZ_QUESTIONS = 10;

	public static void main(String[] args) {
		int[] firstNumbers = new int[N_QUIZ_QUESTIONS];
		int[] secondNumbers = new int[N_QUIZ_QUESTIONS];
		int[] userAnswers = new int[N_QUIZ_QUESTIONS];
		createQuiz(firstNumbers, secondNumbers);
		administerQuiz(firstNumbers, secondNumbers, userAnswers);
		boolean[] gradeQuiz = gradeQuiz(firstNumbers, secondNumbers, userAnswers);
		quizResults(firstNumbers, secondNumbers, userAnswers, gradeQuiz);
	}

	public static void createQuiz(int[] firstNumbers, int[] secondNumbers) {
		for (int i = 0; i < N_QUIZ_QUESTIONS; i++) {
			Random random = new Random();
			firstNumbers[i] = random.nextInt(100) + 1;
			secondNumbers[i] = random.nextInt(100) + 1;
		}
	}

	public static void administerQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
		Scanner input = new Scanner(System.in);
		System.out.println("*************************************");
		System.out.printf("Welcome to the addition quiz!%n%n");
		for (int i = 0; i < N_QUIZ_QUESTIONS; i++) {
			int j = i + 1;
			System.out.printf("Question #%d: What is %d + %d ? ", j, firstNumbers[i], secondNumbers[i]);
			try {
				userAnswers[i] = input.nextInt();
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

	public static boolean[] gradeQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
		boolean[] gradeQuiz = new boolean[N_QUIZ_QUESTIONS];
		for (int i = 0; i < N_QUIZ_QUESTIONS; i++) {
			if (userAnswers[i] == firstNumbers[i] + secondNumbers[i]) {
				gradeQuiz[i] = true;
			}
			else {
				gradeQuiz[i] = false;
			}
		}
		return gradeQuiz;
	}

	public static void quizResults(int[] firstNumbers, int[] secondNumbers, int[] userAnswers, boolean[] gradeQuiz) {
		int totalCorrect = 0;
		System.out.printf("%nHere are the correct answers:%n");
		for (int i = 0; i < N_QUIZ_QUESTIONS; i++) {
			int j = i + 1;
			int correctAnswer = firstNumbers[i] + secondNumbers[i];
			System.out.printf("Question #%d: %d + %d = %d. ", j, firstNumbers[i], secondNumbers[i], correctAnswer);
			if (userAnswers[i] == correctAnswer) {
				System.out.printf("You were CORRECT.%n");
				totalCorrect++;
			}
			else {
				System.out.printf("You said %d, which is INCORRECT.%n", userAnswers[i]);
			}
		}
		System.out.printf("%nYou got %d question(s) correct.%n", totalCorrect);
		System.out.println("Your grade on the quiz is " + totalCorrect*10);
		System.out.println("*************************************");
	}
}