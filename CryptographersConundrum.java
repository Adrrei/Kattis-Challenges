/*
Problem: https://open.kattis.com/problems/conundrum
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptographersConundrum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] text = reader.readLine().toCharArray();

        int index = 0;
        int numDays = 0;

        for (char c : text) {
            if (index % 3 == 0 && c != 'P') {
                numDays++;
            } else if (index % 3 == 1 && c != 'E') {
                numDays++;
            } else if (index % 3 == 2 && c != 'R') {
                numDays++;
            }
            index++;
        }

        System.out.println(numDays);
    }

}
