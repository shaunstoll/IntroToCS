package edu.yu.intro;

import java.util.Scanner;
import java.util.Arrays;

public class StringUtils {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter String: ");
		String s = input.nextLine();
		isPalindrome(s);
	}
	
	public static boolean isPalindrome(final String s) {
		boolean isPalindrome = false;
		if (s == null) {throw new IllegalArgumentException("The String cannot be null.");}

		String noSpaces = s.replaceAll("\\s","");
		char[] charTest = new char[noSpaces.length()];
		noSpaces.getChars(0, noSpaces.length(), charTest, 0);
		// test
		System.out.println(noSpaces);

		char[] sReversed = new char[noSpaces.length()];

		int downCount = noSpaces.length() - 1;
		for (int upCount = 0; upCount < noSpaces.length(); upCount++) {
			sReversed[upCount] = noSpaces.charAt(downCount);
			downCount--;
		}

		if (Arrays.equals(sReversed, charTest)) {isPalindrome = true;}

		return isPalindrome;
	}

	public static String extractExtension(final String filename) {
		if (filename == null || filename.indexOf(".") != filename.lastIndexOf(".")) {throw new RuntimeException("The String cannot be null.");}

		String fileExtension = "";

		if (filename.indexOf(".") != -1) {
			fileExtension = filename.substring(filename.indexOf(".") + 1);
			fileExtension = fileExtension.trim();
		}

		return fileExtension;
	}

	public static boolean isNotEmpty(final String str) {
		boolean notEmpty = true;
		if (str == null) {
			notEmpty = false;
			return notEmpty;
		}
		if (str.length() == 0) {notEmpty = false;}
		
		return notEmpty;
	}

	public static boolean isBlank(final String str) {
		if (str == null) {throw new IllegalArgumentException("String cannot be null.");}

		boolean isBlank = true;
		
		if (str.length() == 0) {isBlank = false;}
		
		return isBlank;
	}

	public static boolean equals(final String str1 , final String str2) {
		boolean isEqual = false;
		if ((str1 == null && str2 == null) || str1.equals(str2)) {isEqual = true;}

		return isEqual;
	}

	public static String join(Object[] array) {
		boolean isNull = true;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				isNull = false;
				break;
			}
		}

		if (isNull == true) {throw new RuntimeException("The Object cannot be null.");}

		String joined = "";

		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				joined += array[i];
			}
		}

		return joined;
	}

	public static String leftPad(final String str, int len) {

		if (str == null || len < str.length()) {
			return str;
		}

		String leftPad = "";

		if (len >= str.length()) {
			if (len <= 20) {
				for (int i = len; i > 0; i--) {leftPad += " ";}
			}
			if (len > 20) {
				for (int i = 20; i > 0; i--) {leftPad += " ";}
			}
		}

		leftPad += str;

		return leftPad;
	}

	public static String trimWhitespaceTillEmpty(final String str) {
		String trimmed = null;

		if (str != null) {
			trimmed = str.trim();
		}

		return trimmed;
	}

	public static String remove(final String str, final char removeIt) {
		if (str == null) {
			return str;
		}

		String removed = str;
		removed = removed.replace(String.valueOf(removeIt), "");

		return removed;
	}
}
















