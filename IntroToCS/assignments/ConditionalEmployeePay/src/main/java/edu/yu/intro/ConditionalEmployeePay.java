package edu.yu.intro;

import java.util.Scanner;
public class ConditionalEmployeePay {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter Employee ID, Hours Worked, Wage Rate, Deductions: ");
		String employeeID = input.next();
		double hrsWorked = input.nextDouble();
		double wageRate = input.nextDouble();
		int deductions = input.nextInt();
		double grossPay = hrsWorked * wageRate;
		double taxes = grossPay * 0.15;
		double netPay = grossPay - taxes - deductions - 0.05 * grossPay;
		double averagePay = netPay / hrsWorked;

		if (hrsWorked < 1.0) {
			System.out.println("Error - min hours must be at least 1.0");
			System.exit(0);
		}
		if (wageRate < 15) {
			System.out.println("Error - min wage rate must be at least $15");
			System.exit(0);
		}
		if (deductions < 1 || deductions > 34) {
			System.out.println("Error - deductions must range between $1 and $34 (inclusive)");
			System.exit(0);
		}
		if (netPay < 0) {
			System.out.println("Error - net pay is negative");
			System.exit(0);
		}

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