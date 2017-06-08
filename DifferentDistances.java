/*
Problem: https://open.kattis.com/problems/differentdistances
Author: Adrian Reithaug
Submitted: June 8th, 2017
Time: 0.23s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferentDistances {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");

            double x1 = Double.parseDouble(data[0]);
            if (x1 == 0) {
                break;
            }

            double y1 = Double.parseDouble(data[1]);
            double x2 = Double.parseDouble(data[2]);
            double y2 = Double.parseDouble(data[3]);
            double p = Double.parseDouble(data[4]);

            double pNormDistance = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1 / p);
            System.out.println(pNormDistance);
        }
    }

}
