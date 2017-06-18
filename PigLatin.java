/*
Problem: https://open.kattis.com/problems/piglatin
Author: Adrian Reithaug
Submitted: June 18th, 2017
Time: 1.26s / 5.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PigLatin {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

        String line = reader.readLine();

        while (line != null) {
            String pigLatin = "";

            for (String word : line.split(" ")) {
                if (vowels.contains(word.charAt(0))) {
                    pigLatin += word + "yay ";
                } else {
                    for (int i = 1; i < word.length(); i++) {
                        if (vowels.contains(word.charAt(i))) {
                            pigLatin += word.substring(i) + word.substring(0, i) + "ay ";
                            break;
                        }
                    }
                }
            }

            System.out.println(pigLatin);

            line = reader.readLine();
        }
    }

}
