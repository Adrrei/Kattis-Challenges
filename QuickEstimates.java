/*
Problem: https://open.kattis.com/problems/quickestimate
Author: Adrian Reithaug
Submitted: June 7th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickEstimates {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            System.out.println(reader.readLine().length());
        }
    }

}
