/*
Problem: https://open.kattis.com/problems/pizza2
Author: Adrian Reithaug
Submitted: January 19th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pizza2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inArr = reader.readLine().split(" ");
        double r = Double.parseDouble(inArr[0]);
        double c = Double.parseDouble(inArr[1]);
        System.out.println((((r - c) * (r - c)) / (r * r)) * 100);

    }

}
