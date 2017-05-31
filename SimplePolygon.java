/*
Problem: https://open.kattis.com/problems/simplepolygon
Author: Adrian Reithaug
Submitted: May 2nd, 2017
Time: 0.73s / 8.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimplePolygon {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());

        while (numTestCases-- > 0) {
            String[] data = reader.readLine().split(" ");
            int numPoints = Integer.parseInt(data[0]);
            List<Point> points = new ArrayList<>();

            int j = 0;
            for (int i = 0; i < numPoints; i++) {
                int x = Integer.parseInt(data[j + 1]);
                int y = Integer.parseInt(data[j + 2]);
                points.add(new Point(x, y));
                j += 2;
            }

            List<Point> polygon = new ArrayList<>();
            List<Point> sortedPoints = new ArrayList<>(points);

            Collections.sort(sortedPoints);

            for (int i = 0; i < sortedPoints.size(); i++) {
                while (polygon.size() >= 2 && pointRelativeToLine(sortedPoints.get(i), polygon.get(polygon.size() - 1), polygon.get(polygon.size() - 2)) > 0) {
                    polygon.remove(polygon.size() - 1);
                }
                polygon.add(sortedPoints.get(i));
            }

            for (int i = sortedPoints.size() - 1; i >= 0; i--) {
                if (!polygon.contains(sortedPoints.get(i))) {
                    polygon.add(sortedPoints.get(i));
                }
            }

            for (int i = 0; i < polygon.size(); i++) {
                System.out.print(points.indexOf(polygon.get(i)) + " ");
            }
            System.out.println("");

        }

    }

    public static int pointRelativeToLine(Point current, Point prev1, Point prev2) {
        Point v1 = new Point(prev1.x - prev2.x, prev1.y - prev2.y);
        Point v2 = new Point(current.x - prev2.x, current.y - prev2.y);

        return v1.x * v2.y - v1.y * v2.x;
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
