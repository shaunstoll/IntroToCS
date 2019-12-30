package edu.yu.intro;

import java.util.Random;
public class SubtractionQuestion implements IntQuestion {
	private final int FIRST_NUMBER;
	private final int SECOND_NUMBER;
	private final String QUESTION;
	private final int ANSWER;
	
	public SubtractionQuestion() {
		Random random = new Random();
		int firstNumber = random.nextInt(100) + 1;
		int secondNumber = random.nextInt(100) + 1;

		while (secondNumber > firstNumber) {
			firstNumber = random.nextInt(100) + 1;
			secondNumber = random.nextInt(100) + 1;
		}

		FIRST_NUMBER = firstNumber;
		SECOND_NUMBER = secondNumber;
		QUESTION = "What is " + FIRST_NUMBER + " - " + SECOND_NUMBER + " ? ";
		ANSWER = FIRST_NUMBER - SECOND_NUMBER;
	}

	@Override
	public String getQuestion() {return QUESTION;}

	@Override
	public int getCorrectAnswer() {return ANSWER;}
}