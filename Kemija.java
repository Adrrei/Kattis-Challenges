/*
Problem: https://open.kattis.com/problems/kemija08
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Kemija {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] sentences = reader.readLine().split(" ");
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

        for (String sentence : sentences) {
            for (int i = 0; i < sentence.length(); i++) {
                if (vowels.contains(sentence.charAt(i))) {
                    System.out.print(sentence.charAt(i));
                    i += 2;
                } else {
                    System.out.print(sentence.charAt(i));
                }
            }
            System.out.print(" ");
        }

    }

}
