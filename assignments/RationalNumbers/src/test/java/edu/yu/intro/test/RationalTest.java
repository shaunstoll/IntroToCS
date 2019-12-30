package edu.yu.intro.test;

import edu.yu.intro.Rational;
import org.junit.*;
import static org.junit.Assert.*;

public class RationalTest {

	@Test(expected = IllegalArgumentException.class) public void zeroDenominator() {
		Rational zeroDenom = new Rational(1, 0);
	}

	@Test(expected = UnsupportedOperationException.class) public void zeroInvert() {
		Rational zeroDenom = new Rational(0, 1);
		zeroDenom.invert();
	}

	@Test public void initialInstance() {
		Rational rational = new Rational();
		assertEquals("numerator", 0, rational.getNumerator());
		assertEquals("denominator", 1, rational.getDenominator());
	}

	@Test public void getNumbers() {
		Rational fiveBySix = new Rational(5, 6);
		assertEquals("numerator", 5, fiveBySix.getNumerator());
		assertEquals("denominator", 6, fiveBySix.getDenominator());
	}
	
	@Test public void negateTest() {
		Rational negateRational = new Rational(10, 11);
		negateRational.negate();
		assertEquals("numerator", -10, negateRational.getNumerator());
		assertEquals("denominator", 11, negateRational.getDenominator());
	}

	@Test public void invertTest() {
		Rational invertRational = new Rational(2, 3);
		invertRational.invert();
		assertEquals("numerator", 3, invertRational.getNumerator());
		assertEquals("denominator", 2, invertRational.getDenominator());
	}

	@Test public void toDoubleTest() {
		Rational toDoubleRational = new Rational(9, 13);
		assertEquals("rational", 0.6923, toDoubleRational.toDouble(), 0.001);
	}
	@Test public void reduceTest() {
		Rational rational1 = new Rational(10, 20);
		Rational rational2 = new Rational(20, 10);
		Rational reduceRational1 = rational1.reduce();
		Rational reduceRational2 = rational2.reduce();
		assertEquals("numerator1", 1, reduceRational1.getNumerator());
		assertEquals("denominator1", 2, reduceRational1.getDenominator());
		assertEquals("numerator2", 2, reduceRational2.getNumerator());
		assertEquals("denominator2", 1, reduceRational2.getDenominator());
	}
	@Test public void addTest() {
		Rational rational1 = new Rational(50, -100);
		Rational rational2 = new Rational(12, 8);
		Rational added = rational1.add(rational2);
		assertEquals("numerator", 1, added.getNumerator());
		assertEquals("denominator", 1, added.getDenominator());
	}
}