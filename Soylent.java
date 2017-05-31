/*
Problem: https://open.kattis.com/problems/soylent
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.14s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soylent {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int CAL_DRINK = 400;
        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            int calories = Integer.parseInt(reader.readLine());
            int consumed = 0;
            int bottles = 0;

            while (true) {
                if (consumed >= calories) {
                    System.out.println(bottles);
                    break;
                }
                consumed += CAL_DRINK;
                bottles++;
            }
        }

    }

}
