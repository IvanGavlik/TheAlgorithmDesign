package distancePoints;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance
 * separating the closest pair of points.
 */
public class DistancePoints {

    PointService pointService = new PointService();

    private static final int MAX = 1000;
    private static final int MIN = 0;
    private static double MAX_DISTANCE = Double.MAX_VALUE;

    // TODO write tests note MOCK
    public PointPar calculate(int n) {
        if(n < 0) {
            return null;
        }

        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            int randomX = ThreadLocalRandom.current().nextInt(MIN, MAX);
            int randomY = ThreadLocalRandom.current().nextInt(MIN, MAX);
            points[i] = new Point(randomX, randomY);
        }

        PointPar minDistancePointPar = new PointPar(null, null, MAX_DISTANCE);
        for(int i = 0; i < points.length; i++) {
            Point start = points[i];
            for (int j = 0; j < points.length; j++) {
                Point destination = points[j];
                if (start.equals(destination)) {
                    continue;
                }
                double distance = this.pointService.calculateDistance(start, destination);

                if(distance < minDistancePointPar.getDistance()) {
                    minDistancePointPar = new PointPar(start, destination, distance);
                }
            }
        }

        return minDistancePointPar;
    }

}

final class PointPar {
    final Point firstPoint;
    final Point secondPoint;
    final double distance;

    public PointPar(Point firstPoint, Point secondPoint, double distance) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.distance = distance;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }


    public Point getSecondPoint() {
        return secondPoint;
    }


    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointPar pointPar = (PointPar) o;
        return Double.compare(pointPar.distance, distance) == 0 && Objects.equals(firstPoint, pointPar.firstPoint) && Objects.equals(secondPoint, pointPar.secondPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint, distance);
    }

    @Override
    public String toString() {
        return "PointPar{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", distance=" + distance +
                '}';
    }
}

class PointService {
    // sqrt ( (x1+x2)^2 + (y1+y2)^2 )
    double calculateDistance(Point start, Point destination) {
        return Math.sqrt(
                Math.pow( destination.getX() - start.getX(), 2) +
                Math.pow( destination.getY() - start.getY(), 2)
        );
    }
}

final class Point {
    final private int x;
    final private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
