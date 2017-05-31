/*
Problem: https://open.kattis.com/problems/roberthood
Author: Adrian Reithaug
Submitted: May 2nd, 2017
Time: 0.70s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobertHood {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numShots = Integer.parseInt(reader.readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numShots; i++) {
            String[] data = reader.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            points.add(new Point(x, y));
        }

        List<Point> polygon = convexHull(points);

        double maxDistance = 0;
        for (int i = 0; i < polygon.size(); i++) {
            for (int j = i + 1; j < polygon.size(); j++) {
                maxDistance = Math.max(maxDistance, euclideanDistance(polygon.get(i), polygon.get(j)));
            }
        }
        System.out.println(maxDistance);
    }

    public static List<Point> convexHull(List<Point> points) {
        List<Point> lowerPolygon = new ArrayList<>();
        List<Point> upperPolygon = new ArrayList<>();

        Collections.sort(points);

        for (int i = 0; i < points.size(); i++) {
            while (lowerPolygon.size() >= 2 && pointRelativeToLine(points.get(i), lowerPolygon.get(lowerPolygon.size() - 1), lowerPolygon.get(lowerPolygon.size() - 2)) <= 0) {
                lowerPolygon.remove(lowerPolygon.size() - 1);
            }
            while (upperPolygon.size() >= 2 && pointRelativeToLine(points.get(points.size() - 1 - i), upperPolygon.get(upperPolygon.size() - 1), upperPolygon.get(upperPolygon.size() - 2)) <= 0) {
                upperPolygon.remove(upperPolygon.size() - 1);
            }
            lowerPolygon.add(points.get(i));
            upperPolygon.add(points.get(points.size() - 1 - i));
        }

        lowerPolygon.addAll(upperPolygon);

        return lowerPolygon;
    }

    public static int pointRelativeToLine(Point current, Point prev1, Point prev2) {
        Point v1 = new Point(prev1.x - prev2.x, prev1.y - prev2.y);
        Point v2 = new Point(current.x - prev2.x, current.y - prev2.y);

        return v1.x * v2.y - v1.y * v2.x;
    }

    public static double euclideanDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            int result = Integer.compare(this.x, p.x);
            if (result == 0) {
                result = Integer.compare(this.y, p.y);
            }
            return result;
        }
    }

}
