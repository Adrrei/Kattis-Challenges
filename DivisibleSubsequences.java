/*
Problem: https://open.kattis.com/problems/divisible
Author: Adrian Reithaug
Submitted: May 3rd, 2017
Time: 0.48s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DivisibleSubsequences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());

        while (numTestCases-- > 0) {
            Map<Integer, Integer> countings = new HashMap<>();
            String[] data = reader.readLine().split(" ");

            int divisor = Integer.parseInt(data[0]);
            int length = Integer.parseInt(data[1]);
            int[] remainder = new int[length];

            data = reader.readLine().split(" ");
            for (int i = 0; i < length; i++) {
                int number = Integer.parseInt(data[i]);
                remainder[i] = (i != 0) ? (number + remainder[i - 1]) % divisor : number % divisor;
                countings.put(remainder[i], (remainder[i] == 0) ? 1 : 0);
            }

            int numSequences = 0;
            for (int i = 0; i < length; i++) {
                numSequences += countings.get(remainder[i]);
                countings.put(remainder[i], countings.get(remainder[i]) + 1);
            }
            System.out.println(numSequences);
        }
    }

}
