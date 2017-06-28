/*
Problem: https://open.kattis.com/problems/okviri
Author: Adrian Reithaug
Submitted: June 28th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Okviri {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();

        String outer = "..#..";
        String inner = ".#.#.";
        String middle = "#." + word.charAt(0) + ".#";
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            count++;

            if (count % 3 == 0) {
                outer += ".*..";
                inner += "*.*.";
                middle += "." + word.charAt(i) + ".*";
            } else {
                outer += ".#..";
                inner += "#.#.";
                middle += "." + word.charAt(i) + ".";
                if ((count + 1) % 3 == 0 && i != word.length() - 1) {
                    middle += "*";
                } else {
                    middle += "#";
                }
            }
        }

        System.out.println(outer + "\n" + inner + "\n" + middle + "\n" + inner + "\n" + outer);
    }

}
