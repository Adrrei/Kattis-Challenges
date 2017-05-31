/*
Problem: https://open.kattis.com/problems/easiest
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.17s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasiestProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(reader.readLine());
            if (number == 0) {
                break;
            }

            int target = sumOfDigits(number);
            int minimal = 11;

            while (true) {
                if (sumOfDigits(number * minimal) == target) {
                    System.out.println(minimal);
                    break;
                }
                minimal++;
            }
        }

    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        char[] numbArr = Integer.toString(number).toCharArray();

        for (char c : numbArr) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}
