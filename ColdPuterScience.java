/*
Problem: https://open.kattis.com/problems/cold
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColdPuterScience {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTemperatures = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");

        int numNegative = 0;
        for (int i = 0; i < numTemperatures; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number < 0) {
                numNegative++;
            }
        }

        System.out.println(numNegative);

    }

}
