/*
Problem: https://open.kattis.com/problems/fizzbuzz
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");
        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        int n = Integer.parseInt(numbers[2]);

        for (int i = 1; i <= n; i++) {
            boolean triggered = false;

            if (i % x == 0) {
                triggered = true;
                System.out.print("Fizz");
            }
            if (i % y == 0) {
                triggered = true;
                System.out.print("Buzz");
            }

            if (triggered) {
                System.out.println("");
            } else {
                System.out.println(i);
            }
        }

    }

}
