package edu.yu.intro.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.yu.intro.JUnit4SqrtApproximation;

public class SqrtApproximationTest {

	@Test(expected = IllegalArgumentException.class) public void sqrtRootCalculationInputCantBeNegative() {
		JUnit4SqrtApproximation.sqrt(-1); 
	}

	@Test(expected = IllegalArgumentException.class) public void calculateSquareRootsInputCantBeNegative() {
		JUnit4SqrtApproximation.calculateSquareRoots(-1);
	}

	@Test public void sqrt0() {
		assertEquals("Sqrt 0", 0, JUnit4SqrtApproximation.sqrt(0), 0.001);
	}

	@Test public void sqrt2() {
		assertEquals("Sqrt 2", 1.414, JUnit4SqrtApproximation.sqrt(2), 0.001);
	}

	@Test public void sqrt42() {
		assertEquals("Sqrt 42", 6.481, JUnit4SqrtApproximation.sqrt(42), 0.001);
	}

	@Test public void sqrt10() {
		assertEquals("Sqrt 10", 3.162, JUnit4SqrtApproximation.sqrt(10), 0.001);
	}
	
	@Test public void calculateSquareRootsMinimalLength() {
		assertArrayEquals("Array 0", new double[] {0}, JUnit4SqrtApproximation.calculateSquareRoots(0), 0.001);
	}

	@Test public void calculateSquareRootsHappyPaths() {
		assertArrayEquals("Array of 6", new double[] {0, 1, 1.414, 1.732, 2, 2.236}, JUnit4SqrtApproximation.calculateSquareRoots(5), 0.001);
	}
}