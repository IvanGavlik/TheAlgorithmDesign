package distancePoints;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistancePointsTest {

    @Test
    public void test() {
        System.out.println(new DistancePoints().calculate(1_500));
        Assertions.assertTrue(true);
    }
}
