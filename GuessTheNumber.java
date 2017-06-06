/*
Problem: https://open.kattis.com/problems/guess
Author: Adrian Reithaug
Submitted: June 6th, 2017
Time: 0.12s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lower = 1;
        int upper = 1000;
        int answer = 500;

        System.out.println(answer);

        while (true) {
            String result = reader.readLine();

            if (result.equals("correct")) {
                break;
            }
            if (result.equals("lower")) {
                upper = answer;
                answer = (lower + upper) / 2;
            }
            if (result.equals("higher")) {
                lower = answer;
                answer = (lower + upper + 1) / 2;
            }

            System.out.println(answer);
        }
    }

}
