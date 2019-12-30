package edu.yu.intro.test;

import edu.yu.intro.StringUtils;
import org.junit.*;
import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test(expected = IllegalArgumentException.class) public void nullString() {
		String empty = null;
		StringUtils.isPalindrome(empty);
	}

	@Test (expected = IllegalArgumentException.class) public void isBlankTest() {
		String empty = null;
		StringUtils.isBlank(empty);
	}

	@Test(expected = RuntimeException.class) public void errorReturnExtention() {
		String empty = null;
		StringUtils.extractExtension(empty);
	}

	@Test(expected = RuntimeException.class) public void errorReturnExtention2() {
		String multipleDots = "filename....txt";
		StringUtils.extractExtension(multipleDots);
	}

	@Test(expected = RuntimeException.class) public void errorReturnExtention3() {
		Object[] empty = new Object[10];
		StringUtils.join(empty);
	}

	@Test public void palindromeTrueTest() {
		boolean t = true;
		String testTrue1 = "   racecar";
		String space = "";
		String oneChar = "4";
		assertEquals(t, StringUtils.isPalindrome(testTrue1));
		assertEquals(t, StringUtils.isPalindrome(space));
		assertEquals(t, StringUtils.isPalindrome(oneChar));
	}

	@Test public void palindromeFalseTest() {
		boolean f = false;
		String testFalse1 = "mother";
		assertEquals(f, StringUtils.isPalindrome(testFalse1));
	}

	@Test public void notEmptyTest() {
		String empty = "";
		String notEmpty = " ";
		String nuLL = null;
		assertEquals(false, StringUtils.isNotEmpty(empty));
		assertEquals(true, StringUtils.isNotEmpty(notEmpty));
		assertEquals(false, StringUtils.isNotEmpty(nuLL));
	}

	@Test public void fileExention() {
		String blank = "";
		assertEquals(blank, StringUtils.extractExtension(blank));
		String file = "filename.   txt  ";
		String txt = "txt";
		assertEquals(txt, StringUtils.extractExtension(file));
	}

	@Test public void equalsTest() {
		String str1 = null;
		String str2 = null;
		String str3 = "";
		String str4 = "";
		assertEquals(true, StringUtils.equals(str1, str2));
		assertEquals(true, StringUtils.equals(str3, str4));
	}

	@Test public void addArray() {
		Object[] items = new Object[]{"Rickie","Is","Going","", null, "Off"};
		String expected = "RickieIsGoingOff";
		assertEquals(expected, StringUtils.join(items));
		Object[] empty = new Object[]{"", ""};
		assertEquals("", StringUtils.join(empty));
	}

	@Test public void trimTest() {
		String s1 = "      James Bond    ";
		String s2 = null;
		String s3 = "";
		assertEquals("James Bond", StringUtils.trimWhitespaceTillEmpty(s1));
		assertEquals(s2, StringUtils.trimWhitespaceTillEmpty(s2));
		assertEquals(s3, StringUtils.trimWhitespaceTillEmpty(s3));
	}

	@Test public void padTest() {
		String s1 = null;
		String s2 = "Fowler";
		String s2_a = "      Fowler";
		String s3 = "Lens is too small";
		String over20 = "The national";
		String over20_a = "                    The national";
		assertEquals(s1, StringUtils.leftPad(s1, 4));
		assertEquals(s2_a, StringUtils.leftPad(s2, 6));
		assertEquals(s3, StringUtils.leftPad(s3, 2));
		assertEquals(over20_a, StringUtils.leftPad(over20, 25));
	}

	@Test public void removeTest() {
		String null1 = null;
		String empty = "";
		String rickie = "R.i.c.k.i.e.";
		assertEquals(null1, StringUtils.remove(null1, 'h'));
		assertEquals(empty, StringUtils.remove(empty, 'h'));
		assertEquals("Rickie", StringUtils.remove(rickie, '.'));
	}
}










