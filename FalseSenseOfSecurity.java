/*
Problem: https://open.kattis.com/problems/falsesecurity
Author: Adrian Reithaug
Submitted: June 6th, 2017
Time: 0.64s / 5.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FalseSenseOfSecurity {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, String> translations = new HashMap<>();
        String[] encrypted = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "..--", ".-.-", "---.", "----"};
        Character[] decrypted = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', ',', '.', '?'};

        for (int i = 0; i < decrypted.length; i++) {
            translations.put(decrypted[i], encrypted[i]);
        }

        String message = reader.readLine();
        while (message != null) {
            String decoded = "";
            int[] lengths = new int[message.length()];

            int i = message.length() - 1;
            for (char c : message.toCharArray()) {
                String value = translations.get(c);
                decoded += value;

                lengths[i--] = value.length();
            }

            int pos = 0;
            for (i = 0; i < lengths.length; i++) {
                String morse = decoded.substring(pos, pos + lengths[i]);
                System.out.print(getKey(translations, morse));
                pos += lengths[i];
            }
            System.out.println("");

            message = reader.readLine();
        }
    }

    private static Character getKey(Map<Character, String> map, String value) {
        for (char key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }

}
