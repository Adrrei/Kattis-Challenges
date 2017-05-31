/*
Problem: https://open.kattis.com/problems/zanzibar
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zanzibar {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] sequence = reader.readLine().split(" ");

            int foreigners = 0;
            int prevValue = Integer.parseInt(sequence[0]);
            for (int i = 1; i < sequence.length - 1; i++) {
                int thisValue = Integer.parseInt(sequence[i]);

                if (thisValue > prevValue * 2) {
                    foreigners += thisValue - (prevValue * 2);
                }
                prevValue = thisValue;

            }
            System.out.println(foreigners);

        }

    }

}
