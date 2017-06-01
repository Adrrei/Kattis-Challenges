/*
Problem: https://open.kattis.com/problems/herman
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Herman {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int radius = Integer.parseInt(reader.readLine());

        double euclidean = Math.PI * Math.pow(radius, 2);
        double taxicab = 2 * Math.pow(radius, 2);

        System.out.println(euclidean + "\n" + taxicab);
    }

}
