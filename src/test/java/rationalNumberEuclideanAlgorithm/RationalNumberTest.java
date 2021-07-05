package rationalNumberEuclideanAlgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RationalNumberTest {

    @Test
    public void testRationalNumberBasic() {
        Rational r = new RationalNumber(120, 90);
        Assertions.assertEquals(4, r.getNumerator());
        Assertions.assertEquals(3, r.getDenominator());

        r = new RationalNumber(90, 120);
        Assertions.assertEquals(3, r.getNumerator());
        Assertions.assertEquals(4, r.getDenominator());
    }

    // TODO more test cases
}
