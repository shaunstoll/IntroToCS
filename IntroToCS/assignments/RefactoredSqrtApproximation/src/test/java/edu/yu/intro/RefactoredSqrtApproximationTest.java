package edu.yu.intro;

import org.junit.*;
import static org.junit.Assert.*;

public class RefactoredSqrtApproximationTest {
	@Test 
	public void sqrt2_5() {
		assertEquals("2.5 test", 1.581, RefactoredSqrtApproximation.sqrt(2.5), 0.001);
		assertEquals("zero test", 0, RefactoredSqrtApproximation.sqrt(0), 0.001);
	}
	@Test(expected = IllegalArgumentException.class) 
	public void negativeInputRejected() {
		RefactoredSqrtApproximation.sqrt(-1); 
		RefactoredSqrtApproximation.calculateSquareRoots(-1);
	}
	@Test
	public void sqrt0toN() {
		assertArrayEquals("array test", new double[]{0, 1}, RefactoredSqrtApproximation.calculateSquareRoots(1), 0.001);
	}
}