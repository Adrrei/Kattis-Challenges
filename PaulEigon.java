/*
Problem: https://open.kattis.com/problems/pauleigon
Author: Adrian Reithaug
Submitted: June 16th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaulEigon {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");

        int numServes = Integer.parseInt(data[0]);
        int sumScore = Integer.parseInt(data[1]) + Integer.parseInt(data[2]);

        System.out.println(((sumScore / numServes) % 2 == 0) ? "paul" : "opponent");
    }

}
