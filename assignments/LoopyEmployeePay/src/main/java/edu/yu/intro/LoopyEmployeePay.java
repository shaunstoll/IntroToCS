package edu.yu.intro;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class LoopyEmployeePay {
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
			System.out.println(e);
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

		for (int lineNumber = 1; scanner.hasNext(); ++lineNumber) {
			String employeeID = scanner.next();
			double hrsWorked = scanner.nextDouble();
			double wageRate = scanner.nextDouble();
			double deductions = scanner.nextDouble();
			int checker = (int)deductions;
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
			if (deductions < 1 || deductions > 34 || checker != deductions) {
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
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		System.out.printf("%n%40s   %.2f%n", "Total Gross Pay:", totalGrossPay);
		System.out.printf("%40s   %.2f%n", "Total Taxes:", totalTaxes);
		System.out.printf("%40s   %s%n", "Employee with Largest Gross Pay:", highestGrossPayEmployee);
		System.out.println("***************************************************************************************");
	}
}