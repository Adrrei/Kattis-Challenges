/*
Problem: https://open.kattis.com/problems/sumkindofproblem
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.42s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumKindOfProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] data = reader.readLine().split(" ");
            int max = Integer.parseInt(data[1]);

            int sumO = max * max;
            int sumE = sumO + max;
            int sumA = sumE / 2;

            System.out.println(data[0] + " " + sumA + " " + sumO + " " + sumE);
        }
    }

}
