/*
Problem: https://open.kattis.com/problems/anewalphabet
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.29s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ANewAlphabet {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, String> translations = new HashMap<>();
        String[] alphabet = {"@", "8", "(", "|)", "3", "#", "6", "[-]", "|", "_|", "|<", "1", "[]\\/[]", "[]\\[]", "0", "|D", "(,)", "|Z", "$", "']['", "|_|", "\\/", "\\/\\/", "}{", "`/", "2"};

        int pos = 0;
        int start = (int) 'a';
        for (int i = start; i < start + alphabet.length; i++) {
            translations.put((char) i, alphabet[pos++]);
        }

        char[] data = reader.readLine().toLowerCase().toCharArray();

        String sentence = "";
        for (char c : data) {
            if (translations.containsKey(c)) {
                sentence += translations.get(c);
            } else {
                sentence += c;
            }
        }
        System.out.println(sentence);
    }

}
