package edu.yu.intro;

public class NotOnLoanException extends Exception {
	public NotOnLoanException(final String msg) {
		super(msg);
	}
}