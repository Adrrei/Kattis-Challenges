/*
Problem: https://open.kattis.com/problems/bing
Author: Adrian Reithaug
Submitted: June 24th, 2017
Time: 2.73s / 5.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BingItOn {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>();
        int numWords = Integer.parseInt(reader.readLine());

        while (numWords-- > 0) {
            String word = reader.readLine();

            int total = 0;
            int pos = getPosition(words, word);

            for (int i = pos; i < words.size(); i++) {
                if (words.get(i).startsWith(word)) {
                    total++;
                } else {
                    break;
                }
            }

            words.add(pos, word);
            System.out.println(total);

        }

    }

    public static int getPosition(List<String> words, String word) {
        int upper = words.size();
        int lower = 0;

        while (upper >= lower) {
            int index = (upper - lower) / 2 + lower;

            if (index == words.size()) {
                return index;
            }

            if (word.compareTo(words.get(index)) <= 0) {
                upper = index - 1;
            } else {
                lower = index + 1;
            }
        }

        return lower;
    }
}
