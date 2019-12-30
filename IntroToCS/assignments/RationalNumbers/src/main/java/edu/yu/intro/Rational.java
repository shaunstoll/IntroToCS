package edu.yu.intro;

public class Rational {
	private int numerator;
	private int denominator;

	public Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}

	public String printRational() {
		String sign = "neutral";

		if ((this.numerator > 0 && this.denominator > 0) || (this.numerator < 0 && this.denominator < 0)) {
			sign = "positive";
		}
		if (this.numerator == 0) {
			sign = "neutral";
		}
		if ((this.numerator < 0 && this.denominator > 0) || (this.numerator > 0 && this.denominator < 0)) {
			sign = "negative";
		}

		String numbersAndSign = this.numerator + " / " + this.denominator + ", " + sign;

		return numbersAndSign;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public static void main(String[] args) {

		Rational myRational = new Rational();
		System.out.println(myRational.printRational());

		// negate test
		Rational negateRational = new Rational(5, 6);
		negateRational.negate();
		System.out.println(negateRational.printRational());

		// invert test
		Rational invertRational = new Rational(2, 3);
		invertRational.invert();
		System.out.println(invertRational.printRational());

		// toDouble test
		Rational toDoubleRational = new Rational(12, 13);
		System.out.println(toDoubleRational.toDouble());

		// reduce test
		Rational reducedRational = new Rational(10, 20);
		reducedRational = reducedRational.reduce();
		System.out.println(reducedRational.printRational());

		// add(final Rational that) test
		Rational test = new Rational(-50, 75);
		Rational added = toDoubleRational.add(test);
		System.out.println(added.printRational());
	}

	public Rational(int num, int denom) {
		if (denom == 0) {
			throw new IllegalArgumentException("The denominator cannot be 0.");
		}
		this.numerator = num;
		this.denominator = denom;
	}

	public void negate() {
		this.numerator = numerator*(-1);
	}

	public void invert() {
		int holder = this.numerator;
		this.numerator = this.denominator;
		this.denominator = holder;

		if (this.denominator == 0) {
			throw new UnsupportedOperationException("The denominator cannot be 0.");
		}
	}

	public double toDouble() {
		double doubleNumerator = (double)this.numerator;
		double doubleDenominator = (double)this.denominator;
		double rationalNumber = doubleNumerator/doubleDenominator;
		return rationalNumber;
	}

	public Rational reduce() {
		int a = numerator;
		int b = denominator;

		if (a >= b) {
			while (b != 0) {
				int t = b;
				b = a % b;
				a = t;
			}
		}

		if (a < b) {
			a = denominator;
			b = numerator; 

			while (b != 0) {
				int t = b;
				b = a % b;
				a = t;
			}
		}
		Rational reducedRational = new Rational();
		reducedRational.numerator = numerator/a;
		reducedRational.denominator = denominator/a;

		return reducedRational;
	}

	public Rational add(final Rational that) {
		Rational addedRational = new Rational(that.numerator, that.denominator);
		addedRational.numerator = addedRational.numerator * this.denominator + this.numerator * addedRational.denominator;
		addedRational.denominator = addedRational.denominator * this.denominator;
		addedRational = addedRational.reduce();

		return addedRational;
	}
}