/*
Problem: https://open.kattis.com/problems/apaxiaaans
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apaxiaaans {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();

        StringBuilder compact = new StringBuilder();
        char prev = word.charAt(0);
        compact.append(prev);

        for (int i = 1; i < word.length(); ++i) {
            char cur = word.charAt(i);
            if (cur != prev) {
                compact.append(cur);
                prev = cur;
            }
        }

        System.out.println(compact);

    }

}
