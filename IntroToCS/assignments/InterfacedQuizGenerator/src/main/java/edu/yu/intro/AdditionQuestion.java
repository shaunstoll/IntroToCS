package edu.yu.intro;

import java.util.Random;
public class AdditionQuestion implements IntQuestion {
	private final int FIRST_NUMBER;
	private final int SECOND_NUMBER;
	private final String QUESTION;
	private final int ANSWER;
	
	public AdditionQuestion() {
		Random random = new Random();
		FIRST_NUMBER = random.nextInt(100) + 1;
		SECOND_NUMBER = random.nextInt(100) + 1;
		QUESTION = "What is " + FIRST_NUMBER + " + " + SECOND_NUMBER + " ? ";
		ANSWER = FIRST_NUMBER + SECOND_NUMBER;
	}

	@Override
	public String getQuestion() {return QUESTION;}

	@Override
	public int getCorrectAnswer() {return ANSWER;}
}