/*
Problem: https://open.kattis.com/problems/lektira
Author: Adrian Reithaug
Submitted: June 13th, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lektira {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();

        String earliest = word;
        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String newWord = subReverse(word, i, j);

                if (newWord.compareTo(earliest) < 0) {
                    earliest = newWord;
                }

            }
        }

        System.out.println(earliest);
    }

    public static String subReverse(String word, int i, int j) {
        StringBuilder a = new StringBuilder(word.substring(0, i)).reverse();
        StringBuilder b = new StringBuilder(word.substring(i, j)).reverse();
        StringBuilder c = new StringBuilder(word.substring(j)).reverse();

        return "" + a + b + c;
    }

}
