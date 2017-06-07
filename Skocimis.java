/*
Problem: https://open.kattis.com/problems/skocimis
Author: Adrian Reithaug
Submitted: June 7th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skocimis {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] positions = reader.readLine().split(" ");

        int a = Integer.parseInt(positions[0]);
        int b = Integer.parseInt(positions[1]);
        int c = Integer.parseInt(positions[2]);

        int max = Math.max(b - a, c - b) - 1;
        System.out.println(max);
    }

}
