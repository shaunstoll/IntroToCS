package edu.yu.intro.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.yu.intro.AckermannFn;

public class AckermannFnTest {

	@Test(expected = IllegalArgumentException.class) public void inputCantBeNegative() {
		AckermannFn.ackermann(-1, 0); 
	}

	@Test public void m0n1() {
		assertEquals("m = 0, n = 1", 2L, AckermannFn.ackermann(0, 1));
	}

	@Test public void m3n10() {
		assertEquals("m = 3, n = 10", 8189L, AckermannFn.ackermann(3, 10));
	}
}