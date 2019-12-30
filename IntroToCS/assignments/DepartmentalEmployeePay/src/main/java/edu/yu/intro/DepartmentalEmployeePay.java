package edu.yu.intro;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class DepartmentalEmployeePay {
	public static void main(String[] args) {
		if (args.length != 2) { final String msg = "Usage: DepartmentalEmployeePay employeeInputFile deptInputFile"; System.err.println(msg); 
		throw new IllegalArgumentException(msg);
	}
	//input files
	final String employee_input = args[0];
	final String department_input = args [1];
	final File inputEmployee = new File(employee_input);
	final File inputDepartment = new File(department_input);
	java.util.Scanner scanner = null;
	java.util.Scanner scannerDepartment = null;

	//exceptions
	try {
		scanner = new Scanner(inputEmployee);
	}
	catch (FileNotFoundException e) {
		System.out.println("***************************************************************************************");
		System.out.println("Employeed Input File not found.");
		System.out.println("***************************************************************************************");
		System.exit(0);
	}
	try {
		scannerDepartment = new Scanner(inputDepartment);
	}
	catch (FileNotFoundException e) {
		System.out.println("***************************************************************************************");
		System.out.println("Department File not found.");
		System.out.println("***************************************************************************************");
		System.exit(0);
	}

	System.out.println("***************************************************************************************");

	int[] employeesCount = new int[10];
	double[] averageGrossPay = new double[10];
	double[] totalGrossPay = new double[10];
	String[] departments = new String[10];
	String checker = null;

	//scanning department_input file first to establish the departments
	for (int cell = 0; scannerDepartment.hasNextLine(); cell++) {
		try {
			checker = scannerDepartment.nextLine();
			departments[cell] = checker;
			//duplicate departments checker
			for (int i = 0; i < departments.length; i++) {
				for (int j = i + 1; j < departments.length; j++)  {
					if (departments[i] != null && departments[j] != null && departments[i].equals(departments[j])) {
						System.out.printf("Error: Duplicate of department '%s' found. Discarding input and advancing.%n", departments[i]);
						departments[cell] = "-";
						--cell;
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			for (int i = 0; i < departments.length; i++) {
				if (checker.equals(departments[i])) {
					System.out.printf("Error: Duplicate of department '%s' found. Discarding input and advancing.%n", departments[i]);
					break;
				}
				if (i == 9 && !checker.equals(departments[i])) {
					System.out.println("Error: There cannot be more than 10 departments.");
					System.out.println("***************************************************************************************");
					System.exit(0);
				}
			}
		}
	}
	for (int lineNumber = 1; scanner.hasNextLine(); ++lineNumber) {
		String lineInput;
		if (scanner.hasNextLine()) {
			lineInput = scanner.nextLine();
		}
		else {
			break;
		}
		String[] splitter = lineInput.trim().split("\\s+");
		if (splitter.length != 5) {
			System.out.printf("Problem at line #"+lineNumber+": Expected 5 tokens per line, found %d. Discarding input and advancing.%n", splitter.length);
			continue;
		}

		String employeeID = splitter[0];
		String hrsWorkedCheck = splitter[1];
		String wageRateCheck = splitter[2];
		String deductionsCheck = splitter[3];
		String departmentID = splitter[4];
		double hrsWorked = 0;
		double wageRate = 0;
		int deductions = 0;

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
			deductions = Integer.parseInt(deductionsCheck);
		}
		catch (NumberFormatException e) {
			System.out.printf("Problem at line #"+lineNumber+": Could not parse deductions [%s] into valid input.%n", deductionsCheck);
			continue;
		}

		if (hrsWorked < 1.0) {
			System.out.println("Problem at line #"+lineNumber+": hours worked must be at least 1.0");
			continue;
		}
		if (wageRate < 15) {
			System.out.println("Problem at line #"+lineNumber+": wage rate must be at least 15");
			continue;
		}
		if (deductions < 1 || deductions > 34) {
			System.out.println("Problem at line #"+lineNumber+": deductions must be an integer between 1 and 34 (inclusive)");
			continue;
		}
		
		double grossPay = hrsWorked * wageRate;
		double taxes = grossPay * 0.15;
		double netPay = grossPay - taxes - deductions - 0.05 * grossPay;
		double averagePay = netPay / hrsWorked;

		if (netPay < 0) {
			System.out.println("Problem at line #"+lineNumber+": net pay is negative");
			continue;
		}
		for (int i = 0; i < departments.length; i++) {
			if (departmentID.equals(departments[i])) {
				grossPay = hrsWorked * wageRate;
				++employeesCount[i];
				totalGrossPay[i] += grossPay;
				break;
			}
			else if (i == 9) {
				System.out.printf("Problem at line #"+lineNumber+": '%s' is an invalid department. Discarding input and advancing.%n", departmentID);
			}
			else {
				continue;
			}
		}
	}
	if (employeesCount[0] == 0 && employeesCount[1] == 0 && employeesCount[2] == 0 && employeesCount[3] == 0 && employeesCount[4] == 0 && employeesCount[5] == 0 && employeesCount[6] == 0 && employeesCount[7] == 0 && employeesCount[8] == 0 && employeesCount[9] == 0) {
		System.out.println("There is no valid input to calculate.");
	}
	else {
		System.out.printf("%n%20s%17s%20s%20s%n", "Department", "# Employees", "Total Gross Pay", "Average Gross Pay");
	}	

	for (int i = 0; i < departments.length; i++) {
		if (employeesCount[i] != 0) {
			averageGrossPay[i] = totalGrossPay[i] / employeesCount[i];
			System.out.printf("%20s%13d%20.2f%20.2f%n", departments[i], employeesCount[i], totalGrossPay[i], averageGrossPay[i]);
		}
	}
		System.out.println("***************************************************************************************");
	}
}