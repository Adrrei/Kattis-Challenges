/*
Problem: https://open.kattis.com/problems/trik
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trik {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] moves = reader.readLine().toCharArray();
        int index = 1;

        for (char c : moves) {
            switch (c) {
                case 'A':
                    if (index != 3) {
                        index = (index == 1) ? 2 : 1;
                    }
                    break;
                case 'B':
                    if (index != 1) {
                        index = (index == 2) ? 3 : 2;
                    }
                    break;
                case 'C':
                    if (index != 2) {
                        index = (index == 1) ? 3 : 1;
                    }
                    break;
            }
        }

        System.out.println(index);
    }

}
