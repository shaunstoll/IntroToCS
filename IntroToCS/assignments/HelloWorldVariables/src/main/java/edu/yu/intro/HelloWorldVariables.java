package edu.yu.intro;

public class HelloWorldVariables {
	public static void main (final String[] args) {
		System.out.println("Hello World!");
		int correctPillars = 3;
		System.out.print("The world stands on " + correctPillars);
      	System.out.println(" pillars");
      
      	double incorrectPillars = 2.52;
      	System.out.print("Not " + incorrectPillars);
      	System.out.println(" pillars");

      	boolean trueStatement = true;
      	System.out.print("and ... this is a very " + trueStatement);
      	System.out.println(" statement");
	}
}