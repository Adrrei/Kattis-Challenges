/*
Problem: https://uib.kattis.com/problems/mosquitoes
Author: Adrian Reithaug
Submitted: March 19th, 2017
Time: 0.22s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeskyMosquitoes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(reader.readLine());
        while (numTestCases-- > 0) {
            reader.readLine();
            String[] data = reader.readLine().split(" ");

            int numMosquitoes = Integer.parseInt(data[0]);
            double radius = Double.parseDouble(data[1]) / 2.0;
            Coordinate[] mosquitoes = new Coordinate[numMosquitoes];

            for (int i = 0; i < numMosquitoes; i++) {
                data = reader.readLine().split(" ");
                double x = Double.parseDouble(data[0]);
                double y = Double.parseDouble(data[1]);
                mosquitoes[i] = new Coordinate(x, y);
            }

            int bestCatch = 0;
            for (int i = 0; i < numMosquitoes; i++) {
                for (int j = 0; j < numMosquitoes; j++) {
                    int caughtMosquitoes = 0;

                    Coordinate center = centerOfCircle(mosquitoes[i], mosquitoes[j], radius);
                    for (int k = 0; k < numMosquitoes; k++) {
                        double pointsDistance = Math.sqrt(Math.pow(center.x - mosquitoes[k].x, 2) + Math.pow(center.y - mosquitoes[k].y, 2));
                        if (pointsDistance <= radius) {
                            caughtMosquitoes++;
                        }
                    }

                    if (caughtMosquitoes > bestCatch) {
                        bestCatch = caughtMosquitoes;
                    }
                }
            }

            System.out.println(bestCatch);
        }
    }

    public static double distanceBetweenPoints(Coordinate p1, Coordinate p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static Coordinate centerOfCircle(Coordinate p1, Coordinate p2, double radius) {
        Coordinate midpoint = new Coordinate((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        double lengthP1ToMidpoint = distanceBetweenPoints(p1, midpoint);
        double lengthMidToCenter = Math.sqrt(Math.pow(radius, 2) - Math.pow(lengthP1ToMidpoint, 2));
        double radians = Math.atan2(p1.x - p2.x, p2.y - p1.y);

        Coordinate centerOfCircle = new Coordinate(lengthMidToCenter * Math.cos(radians) + midpoint.x, lengthMidToCenter * Math.sin(radians) + midpoint.y);
        return centerOfCircle;
    }

    public static class Coordinate {

        double x, y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}
