/*
Problem: https://open.kattis.com/problems/mixedfractions
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.16s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MixedFractions {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] values = reader.readLine().split(" ");

            int numerator = Integer.parseInt(values[0]);
            int denominator = Integer.parseInt(values[1]);

            if (numerator == 0 && denominator == 0) {
                break;
            }

            int total = numerator / denominator;
            int remainder = numerator % denominator;

            System.out.println(total + " " + remainder + " / " + denominator);
        }

    }

}
