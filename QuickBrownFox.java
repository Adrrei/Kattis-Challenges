/*
Problem: https://open.kattis.com/problems/quickbrownfox
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuickBrownFox {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            List<Character> letters = new ArrayList<>();

            char[] text = reader.readLine().toLowerCase().toCharArray();

            for (char c : text) {
                if (c >= 'a' && c <= 'z') {
                    letters.add(c);
                }
            }

            int start = (char) 'a';
            int end = (char) 'z';
            String missing = "";

            for (int i = start; i <= end; i++) {
                char c = (char) i;
                if (!letters.contains(c)) {
                    missing += c;
                }
            }

            if (missing.equals("")) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + missing);
            }

        }
    }

}
