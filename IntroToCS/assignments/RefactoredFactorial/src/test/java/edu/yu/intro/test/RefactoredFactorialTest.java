package edu.yu.intro.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.yu.intro.RefactoredFactorial;

public class RefactoredFactorialTest {
	@Test 
	public void factorial0() {
		assertEquals("0 test", 1, RefactoredFactorial.factorial(1));
		assertEquals("15 test", 1307674368000L, RefactoredFactorial.factorial(15));
	}

	@Test(expected = IllegalArgumentException.class) public void negativeInputRejected() {
		RefactoredFactorial.factorial(-1); 
	}
} 