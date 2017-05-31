/*
Problem: https://open.kattis.com/problems/pet
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pet {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numEvenings = 5;

        int max = 0;
        int winner = 1;
        int contestant = 1;

        while (numEvenings-- > 0) {
            String[] grades = reader.readLine().split(" ");
            int sum = 0;

            for (String score : grades) {
                sum += Integer.parseInt(score);
            }
            if (sum > max) {
                winner = contestant;
                max = sum;
            }
            contestant++;
        }

        System.out.println(winner + " " + max);

    }

}
