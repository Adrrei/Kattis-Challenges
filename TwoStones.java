/*
Problem: https://open.kattis.com/problems/twostones
Author: Adrian Reithaug
Submitted: January 19th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoStones {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (Integer.parseInt(reader.readLine()) % 2 == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }

}
