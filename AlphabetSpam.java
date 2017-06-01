/*
Problem: https://open.kattis.com/problems/alphabetspam
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.10s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetSpam {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] text = reader.readLine().toCharArray();

        double whitespace = 0;
        double lowercase = 0;
        double uppercase = 0;
        double symbols = 0;

        for (char c : text) {
            if (c == '_') {
                whitespace++;
            } else if (c >= 'a' && c <= 'z') {
                lowercase++;
            } else if (c >= 'A' && c <= 'Z') {
                uppercase++;
            } else {
                symbols++;
            }
        }

        System.out.println((whitespace / text.length) + "\n" + (lowercase / text.length) + "\n" + (uppercase / text.length) + "\n" + (symbols / text.length));
    }

}
