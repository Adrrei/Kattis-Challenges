/*
Problem: https://open.kattis.com/problems/rijeci
Author: Adrian Reithaug
Submitted: June 10th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rijeci {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer numLetters = Integer.parseInt(reader.readLine());

        int numA = 1;
        int numB = 0;

        while (numLetters-- > 0) {
            int prevNumA = numA;
            numA = numB;
            numB += prevNumA;
        }

        System.out.println(numA + " " + numB);
    }
}
