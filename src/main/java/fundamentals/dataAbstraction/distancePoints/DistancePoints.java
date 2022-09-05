package fundamentals.dataAbstraction.distancePoints;

import java.util.Objects;

/**
 * takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance
 * separating the closest pair of points.
 */
public class DistancePoints {

    public static final double MAX_DISTANCE = Double.MAX_VALUE;

    PointService pointService;

    public DistancePoints(PointService pointService) {
        this.pointService = pointService;
    }

    public PointPar findSmallestDistance(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("There must be at least two points");
        }

        PointPar minDistancePointPar = new PointPar(null, null, MAX_DISTANCE);
        for (Point start : points) {
            for (Point destination : points) {
                if (start.equals(destination)) {
                    continue;
                }
                double distance = this.pointService.calculateDistance(start, destination);

                if (distance < minDistancePointPar.getDistance()) {
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

    public Point getFirstPoint() { return firstPoint;}

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
        if(start == null || destination == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        return Math.sqrt(
                Math.pow( destination.getX() - start.getX(), 2) +
                Math.pow( destination.getY() - start.getY(), 2)
        );
    }
}

final class Point {
    private static int idCounter = 0;
    final private int x;
    final private int y;
    final private int id;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        idCounter += 1;
        this.id = idCounter;
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
        return id == point.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
