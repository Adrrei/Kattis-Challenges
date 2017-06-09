/*
Problem: https://open.kattis.com/problems/secretmessage
Author: Adrian Reithaug
Submitted: June 9th, 2017
Time: 1.80s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretMessage {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String text = reader.readLine();
            int square = (int) Math.ceil(Math.sqrt(text.length()));

            int pos = 0;
            int length = square * square;
            char[][] textGrid = new char[length][length];

            for (int i = 0; i < square; i++) {
                for (int j = 0; j < square; j++) {
                    textGrid[i][j] = (pos == text.length()) ? '*' : text.charAt(pos++);
                }
            }

            for (int i = 0; i < square; i++) {
                for (int j = square - 1; j >= 0; j--) {
                    if (textGrid[j][i] != '*') {
                        System.out.print(textGrid[j][i]);
                    }
                }
            }
            System.out.println("");

        }
    }
}
