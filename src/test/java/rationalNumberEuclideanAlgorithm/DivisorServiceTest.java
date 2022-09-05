package rationalNumberEuclideanAlgorithm;

import fundamentals.dataAbstraction.rationalNumberEuclideanAlgorithm.DivisorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisorServiceTest {

    @Test
    public void testGCD() {
        Assertions.assertEquals(15, DivisorService.greatestCommonDivisor(210, 45));
        Assertions.assertEquals(15, DivisorService.greatestCommonDivisor(45, 210));
        Assertions.assertEquals(2, DivisorService.greatestCommonDivisor(2, 4));
        Assertions.assertEquals(1, DivisorService.greatestCommonDivisor(1, 4));
        Assertions.assertEquals(1, DivisorService.greatestCommonDivisor(4, 1));
    }
}
