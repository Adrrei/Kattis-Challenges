/*
Problem: https://open.kattis.com/problems/karte
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Karte {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cards = reader.readLine();
        Map<String, Integer> cardLabels = new HashMap<>();

        char[] suits = {'P', 'K', 'H', 'T'};
        int[] numSuits = {13, 13, 13, 13};
        boolean error = false;

        for (int i = 0; i < cards.length(); i += 3) {
            String substr = cards.substring(i, i + 3);
            if (cardLabels.containsKey(substr)) {
                error = true;
                break;
            } else {
                for (int j = 0; j < suits.length; j++) {
                    if (substr.charAt(0) == suits[j]) {
                        numSuits[j]--;
                        break;
                    }
                }
                cardLabels.put(substr, 1);
            }
        }

        if (error) {
            System.out.println("GRESKA");
        } else {
            for (int i = 0; i < numSuits.length; i++) {
                System.out.print(numSuits[i] + " ");
            }
        }

    }

}
