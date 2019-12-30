package edu.yu.intro;

import java.io.*;
import java.util.Scanner;
public class ExceptionalEmployeePay {
	public static void main(String[] args) {
		if (args.length != 1) {
			final String msg = "Usage: LoopyEmployeePayname_of_input file"; 
			System.err.println(msg);
			throw new IllegalArgumentException(msg);
		}
		final String employee_input = args [0];
		final File input = new File(employee_input);
		java.util.Scanner scanner = null;

		try {
			scanner = new Scanner(input);
		}
		catch (FileNotFoundException e) {
			System.out.println("***************************************************************************************");
			System.out.println("File not found.");
			System.out.println("***************************************************************************************");
			System.exit(0);
		}

		if (!scanner.hasNext()) {
			System.out.println("***************************************************************************************");
			System.out.println("There is no data.");
			System.out.println("***************************************************************************************");
			System.exit(0);
		}
		System.out.println("***************************************************************************************");
		System.out.printf("%18s         Gross Pay         Taxes         Net Pay         Average Pay%n", "ID");
		
		double totalGrossPay = 0;
		double totalTaxes = 0;
		String highestGrossPayEmployee = "N/A";
		double highestGrossPayChecker = 0;

		for (int lineNumber = 1; scanner.hasNextLine(); ++lineNumber) {
			String lineInput;
			if (scanner.hasNextLine()) {
				lineInput = scanner.nextLine();
			}
			else {
				break;
			}
			String[] splitter = lineInput.trim().split("\\s+");

			if (splitter.length != 4) {
				System.out.printf("Problem at line #"+lineNumber+": Expected 4 tokens per line, found %d. Discarding input and advancing.%n", splitter.length);
				continue;
			}
			String employeeID = splitter[0];
			String hrsWorkedCheck = splitter[1];
			String wageRateCheck = splitter[2];
			String deductionsCheck = splitter[3];
			double hrsWorked = 0;
			double wageRate = 0;
			double deductions = 0;
			int intCast;
			try {
				hrsWorked = Double.parseDouble(hrsWorkedCheck);
			}
			catch (NumberFormatException e) {
				System.out.printf("Problem at line #"+lineNumber+": Could not parse Hours Worked [%s] into valid input.%n", hrsWorkedCheck);
				continue;
			}
			try {
				wageRate = Double.parseDouble(wageRateCheck);
			}
			catch (NumberFormatException e) {
				System.out.printf("Problem at line #"+lineNumber+": Could not parse Wage Rate [%s] into valid input.%n", wageRateCheck);
				continue;
			}
			try {
				deductions = Double.parseDouble(deductionsCheck);
				intCast = (int)deductions;
			}
			catch (NumberFormatException e) {
				System.out.printf("Problem at line #"+lineNumber+": Could not parse deductions [%s] into valid input.%n", deductionsCheck);
				continue;
			}

			double grossPay = hrsWorked * wageRate;
			double taxes = grossPay * 0.15;
			double netPay = grossPay - taxes - deductions - 0.05 * grossPay;
			double averagePay = netPay / hrsWorked;

			if (hrsWorked < 1.0) {
				System.out.println("Problem at line #"+lineNumber+": hours worked must be at least 1.0");
				continue;
			}
			if (wageRate < 15) {
				System.out.println("Problem at line #"+lineNumber+": wage rate must be at least 15");
				continue;
			}
			if (deductions < 1 || deductions > 34 || intCast != deductions) {
				System.out.println("Problem at line #"+lineNumber+": deductions must be an integer between 1 and 34 (inclusive)");
				continue;
			}
			if (netPay < 0) {
				System.out.println("Problem at line #"+lineNumber+": net pay is negative");
				continue;
			}
			else {
				System.out.printf("%20s%14.2f%17.2f%15.2f%16.2f%n", employeeID, grossPay, taxes, netPay, averagePay);
				totalGrossPay += grossPay;
				totalTaxes += taxes;
			}
			if (grossPay > highestGrossPayChecker) {
				highestGrossPayChecker = grossPay;
				highestGrossPayEmployee = employeeID;
			}
		}
		System.out.printf("%n%40s   %.2f%n", "Total Gross Pay:", totalGrossPay);
		System.out.printf("%40s   %.2f%n", "Total Taxes:", totalTaxes);
		System.out.printf("%40s   %s%n", "Employee with Largest Gross Pay:", highestGrossPayEmployee);
		System.out.println("***************************************************************************************");
	}
}