/*
Problem: https://open.kattis.com/problems/simonsays
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimonSays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());
        while (numCases-- > 0) {
            String sentence = reader.readLine();

            if (sentence.length() > 11 && sentence.substring(0, 10).equals("Simon says")) {
                System.out.println(sentence.substring(11, sentence.length()));
            }

        }
    }

}
