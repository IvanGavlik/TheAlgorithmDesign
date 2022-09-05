package fundamentals.dataAbstraction.rationalNumberEuclideanAlgorithm;

import java.util.Objects;

/**

 You do not have to worry about testing for overflow, but use as instance variables
 two long values that represent the numerator and denominator to limit the possibility of overflow.

 Use Euclid's algorithm to ensure that the numerator and denominator never have any common factors.
 Include a test client that exercises all of your methods.

 */
public class RationalNumberEuclideanAlgorithm {
}

interface Rational {

    long getNumerator();

    long getDenominator();

    Rational plus(Rational rational);

    Rational minus(Rational rational);

    Rational times(Rational rational);

    Rational divide(Rational rational);

}

class DivisorService {

    /**
     * Euclid's algorithm, is an efficient method for computing the greatest common divisor (GCD) of two integers (numbers), the largest number that divides them both without a remainder.
     * For more info @see: https://en.wikipedia.org/wiki/Euclidean_algorithm
     * and @see https://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
     */
    public static long greatestCommonDivisor(long n1, long n2) {
        if (n1 < n2) {
            long temp = n1;
            n1 = n2;
            n2 = temp;
        }
        long remainder = n1 % n2;
        if (remainder == 0) {
            return n2;
        }
        return greatestCommonDivisor(n2, remainder);
    }
}

/**
 * Immutable always return new
 */
final class RationalNumber implements Rational {
    private final long numerator;
    private final long denominator;

    public RationalNumber(long numerator, long denominator) {
        // TODO DivisorService
        // TOODO denominator NOT NULL
        if (denominator == 0) {
            throw new RuntimeException("Denominator can not be 0");
        }
        long gcd = Long.MAX_VALUE;
        do {
            gcd = DivisorService.greatestCommonDivisor(numerator, denominator);
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        } while (gcd > 1);

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    @Override
    public Rational plus(Rational rational) {
        return null;
    }

    @Override
    public Rational minus(Rational rational) {
        return null;
    }

    @Override
    public Rational times(Rational rational) {
        return null;
    }

    @Override
    public Rational divide(Rational rational) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "RationalNumber{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
