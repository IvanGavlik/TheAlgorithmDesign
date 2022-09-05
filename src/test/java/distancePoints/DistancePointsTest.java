package distancePoints;

import fundamentals.dataAbstraction.distancePoints.DistancePoints;
import fundamentals.dataAbstraction.distancePoints.Point;
import fundamentals.dataAbstraction.distancePoints.PointPar;
import fundamentals.dataAbstraction.distancePoints.PointService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistancePointsTest {

    private DistancePoints distancePoints;


    @BeforeEach()
    public void init() {
        this.distancePoints = new DistancePoints(new PointService());
    }

    /**
     * When arguments are not good throw IllegalArgumentException
     */
    @Test
    public void passIllegalArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.distancePoints.findSmallestDistance(null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.distancePoints.findSmallestDistance(new Point[1]));

        Point[] oneElementArray = { new Point(1, 1) };
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.distancePoints.findSmallestDistance(oneElementArray));

        Point[] haveNull = { new Point(1, 5), new Point(1, 1), null };
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.distancePoints.findSmallestDistance(haveNull));
    }

    /**
     * Calculate distance for points
     */
    @Test()
    public void findMinDistance() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point[] points = { p1, p2, new Point(5, 5),  };

        PointPar expectedPair = new PointPar(p1, p2, 2.0);
        Assertions.assertEquals(expectedPair, this.distancePoints.findSmallestDistance(points));
    }

    /**
     * Calculate distance for points
     */
    @Test()
    public void whenIsZeroMinDistance() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point[] points = { p1, p2, new Point(5, 5),  };

        PointPar expectedPair = new PointPar(p1, p2, 0.0);
        Assertions.assertEquals(expectedPair, this.distancePoints.findSmallestDistance(points));
    }
}
