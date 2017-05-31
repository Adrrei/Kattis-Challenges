/*
Problem: https://open.kattis.com/problems/jabuke
Author: Adrian Reithaug
Submitted: March 11th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jabuke {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        Coordinate point1 = new Coordinate(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        data = reader.readLine().split(" ");
        Coordinate point2 = new Coordinate(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        data = reader.readLine().split(" ");
        Coordinate point3 = new Coordinate(Integer.parseInt(data[0]), Integer.parseInt(data[1]));

        double antesArea = calculateArea(point1, point2, point3);
        int antesTrees = 0;
        int numAppleTrees = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numAppleTrees; i++) {
            data = reader.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            Coordinate thisPoint = new Coordinate(x, y);
            if (withinArea(antesArea, thisPoint, point1, point2, point3)) {
                antesTrees++;
            }
        }
        System.out.println(antesArea);
        System.out.println(antesTrees);
    }

    public static boolean withinArea(double antesArea, Coordinate thisPoint, Coordinate point1, Coordinate point2, Coordinate point3) {
        double areaA = calculateArea(thisPoint, point2, point3);
        double areaB = calculateArea(point1, thisPoint, point3);
        double areaC = calculateArea(point1, point2, thisPoint);

        return (antesArea == (areaA + areaB + areaC));
    }

    public static double calculateArea(Coordinate p1, Coordinate p2, Coordinate p3) {
        return Math.abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0;
    }

    public static class Coordinate {

        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
