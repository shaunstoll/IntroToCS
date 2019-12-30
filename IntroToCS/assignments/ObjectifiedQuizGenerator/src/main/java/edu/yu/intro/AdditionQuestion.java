package edu.yu.intro;

import java.util.Random;
public class AdditionQuestion {
	private final int FIRST_NUMBER;
	private final int SECOND_NUMBER;
	private static int questionNumber = 0;
	private final String QUESTION;
	private final int ANSWER;
	
	public AdditionQuestion() {
		Random random = new Random();
		FIRST_NUMBER = random.nextInt(100) + 1;
		SECOND_NUMBER = random.nextInt(100) + 1;
		QUESTION = ++questionNumber + ") " + FIRST_NUMBER + " + " + SECOND_NUMBER + " = ";
		ANSWER = FIRST_NUMBER + SECOND_NUMBER;
	}

	public String getQuestion() {
		return QUESTION;
	}

	public int getCorrectAnswer() {
		return ANSWER;
	}
}