/*
Problem: https://open.kattis.com/problems/humancannonball2
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazingHumanCannonball {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final double ACCELERATION = 9.81;
        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] values = reader.readLine().split(" ");

            double velocity = Double.parseDouble(values[0]);
            double degrees = Math.toRadians(Double.parseDouble(values[1]));
            double distToWall = Double.parseDouble(values[2]);
            double lowerHeight = Double.parseDouble(values[3]) + 1;
            double upperHeight = Double.parseDouble(values[4]) - 1;

            double time = distToWall / (velocity * Math.cos(degrees));
            double y = velocity * time * Math.sin(degrees) - ACCELERATION * (1.0 / 2.0) * Math.pow(time, 2);

            if (lowerHeight <= y && upperHeight >= y) {
                System.out.println("Safe");
            } else {
                System.out.println("Not Safe");
            }
        }

    }

}
