/*
Problem: https://open.kattis.com/problems/oddities
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Oddities {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            System.out.print(number);

            if (number % 2 == 0) {
                System.out.print(" is even");
            } else {
                System.out.print(" is odd");
            }
            System.out.println("");
        }

    }

}
