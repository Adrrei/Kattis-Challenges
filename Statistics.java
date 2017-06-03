/*
Problem: https://open.kattis.com/problems/statistics
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int caseNumber = 1;
        String line = reader.readLine();
        while (line != null) {
            String[] strNumbers = line.split(" ");

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 1; i < strNumbers.length; i++) {
                int value = Integer.parseInt(strNumbers[i]);
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }

            System.out.println("Case " + caseNumber++ + ": " + min + " " + max + " " + (max - min));

            line = reader.readLine();
        }

    }

}
