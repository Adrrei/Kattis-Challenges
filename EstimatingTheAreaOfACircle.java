/*
Problem: https://open.kattis.com/problems/estimatingtheareaofacircle
Author: Adrian Reithaug
Submitted: June 8th, 2017
Time: 0.22s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EstimatingTheAreaOfACircle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");

            double radius = Double.parseDouble(data[0]);
            double pointsTotal = Integer.parseInt(data[1]);
            double pointsInside = Integer.parseInt(data[2]);

            if (radius == 0 && pointsTotal == 0 && pointsInside == 0) {
                break;
            }
            
            double radius2 = radius * radius;
            double realR = Math.PI * radius2;
            double estimateR = 4 * radius2 * (pointsInside / pointsTotal);

            System.out.println(realR + " " + estimateR);
        }
    }

}
