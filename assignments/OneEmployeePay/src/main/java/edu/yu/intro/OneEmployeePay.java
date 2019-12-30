package edu.yu.intro;

import java.util.Scanner;
public class OneEmployeePay {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Employee ID, Hours Worked, Wage Rate, Deductions: ");
		String employeeID = input.next();
		double hrsWorked = input.nextDouble();
		double wageRate = input.nextDouble();
		int deductions = input.nextInt();
		double grossPay = hrsWorked * wageRate;
		double taxes = grossPay * 0.15;
		double netPay = grossPay - taxes - deductions - 0.05 * grossPay;
		double averagePay = netPay / hrsWorked;

		System.out.println("**********************************************************************");
		System.out.println("INPUT ...");
		System.out.printf("Employee ID:        %s%n", employeeID);
		System.out.printf("Hours Worked:       %.2f%n", hrsWorked);
		System.out.printf("Wage Rate:          %.2f%n", wageRate);
		System.out.printf("Deductions:         %d%n", deductions);
		System.out.printf("%n%n%nOUTPUT ...%n");
		System.out.printf("Gross Pay:          %.2f%n", grossPay);
		System.out.printf("Taxes:              %.2f%n", taxes);
		System.out.printf("Net Pay:            %.2f%n", netPay);
		System.out.printf("Average Pay:        %.2f%n", averagePay);
		System.out.println("**********************************************************************");
	}
}