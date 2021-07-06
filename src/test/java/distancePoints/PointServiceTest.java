package distancePoints;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointServiceTest {

    private PointService pointService;

    @BeforeEach()
    public void init() {
        this.pointService = new PointService();
    }

    /**
     * Test when null is passed to calculateDistance throw IllegalArgumentException
     */
    @Test()
    public void passNullInCalculateDistance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.pointService.calculateDistance(new Point(1, 1), null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.pointService.calculateDistance(null, new Point(1, 1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.pointService.calculateDistance(null, null));
    }

    /**
     * Calculate distance
     */
    @Test()
    public void testCalculateDistance() {
        Assertions.assertEquals(2.8284271247461903, this.pointService.calculateDistance(new Point(1, 2), new Point(3, 4)));
        Assertions.assertEquals(497.3017192811624, this.pointService.calculateDistance(new Point(100, 345), new Point(-345, 567)));
        Assertions.assertEquals(357.169427583045, this.pointService.calculateDistance(new Point(-345, 0), new Point(12, -11)));
        Assertions.assertEquals(0.0, this.pointService.calculateDistance(new Point(1, 1), new Point(1, 1)));
    }
}
