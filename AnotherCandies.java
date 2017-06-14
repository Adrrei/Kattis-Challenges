/*
Problem: https://open.kattis.com/problems/anothercandies
Author: Adrian Reithaug
Submitted: June 14th, 2017
Time: 0.19s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherCandies {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            reader.readLine();
            int children = Integer.parseInt(reader.readLine());

            long candies = 0;
            for (int i = 0; i < children; i++) {
                candies += Long.parseLong(reader.readLine()) % children;
            }
            System.out.println(candies % children == 0 ? "YES" : "NO");
        }
    }

}
