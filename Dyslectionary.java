/*
Problem: https://open.kattis.com/problems/dyslectionary
Author: Adrian Reithaug
Submitted: June 22nd, 2017
Time: 0.26s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dyslectionary {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        boolean finished = false;

        while ((input = reader.readLine()) != null) {
            List<String> dictionary = new ArrayList<>();
            int maxLength = 0;

            while (true) {
                if (input == null) {
                    finished = true;
                    break;
                }

                if (input.isEmpty()) {
                    break;
                }

                dictionary.add(input);

                if (input.length() > maxLength) {
                    maxLength = input.length();
                }

                input = reader.readLine();
            }

            for (int i = 0; i < dictionary.size(); i++) {
                String word = dictionary.get(i);
                int length = maxLength - word.length();

                String spaces = "";
                for (int j = 0; j < length; j++) {
                    spaces += " ";
                }

                word = spaces + word;

                dictionary.set(i, word);
            }

            Collections.sort(dictionary, (String word1, String word2) -> {
                for (int i = word1.length() - 1; i >= 0; i--) {
                    if (word1.charAt(i) != word2.charAt(i)) {
                        return word1.charAt(i) - word2.charAt(i);
                    }
                }

                return 0;
            });

            for (String word : dictionary) {
                System.out.println(word);
            }

            if (!finished) {
                System.out.println("");
            }

        }

    }

}
