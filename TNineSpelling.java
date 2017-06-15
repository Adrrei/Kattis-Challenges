/*
Problem: https://open.kattis.com/problems/t9spelling
Author: Adrian Reithaug
Submitted: June 15th, 2017
Time: 0.27s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TNineSpelling {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, String> codes = new HashMap<>();
        String state = "2";

        for (int i = (int) 'a'; i < (int) 'z' + 1; i++) {
            codes.put((char) i, state);
            state += state.charAt(0);

            if (state.length() >= 4) {
                if (i != 'r' && i != 'y') {
                    state = Integer.toString(Character.getNumericValue(state.charAt(0) + 1));
                }
            }
        }
        codes.put(' ', "0");
        codes.put('_', "_");

        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numCases; i++) {
            char[] message = reader.readLine().toCharArray();
            System.out.print("Case #" + i + ": ");

            char prevChar = '_';
            for (char c : message) {
                if (codes.get(prevChar).charAt(0) == codes.get(c).charAt(0)) {
                    System.out.print(" ");
                }

                System.out.print(codes.get(c));
                prevChar = c;
            }
            System.out.println("");
        }

    }

}
