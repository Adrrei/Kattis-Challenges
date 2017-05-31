/*
Problem: https://open.kattis.com/problems/bela
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bela {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] handSuit = reader.readLine().split(" ");
        int numHands = Integer.parseInt(handSuit[0]) * 4;
        String suit = handSuit[1];

        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 11);
        scores.put("K", 4);
        scores.put("Q", 3);
        scores.put("T", 10);
        scores.put("JX", 20);
        scores.put("JY", 2);
        scores.put("9X", 14);
        scores.put("9Y", 0);

        int sum = 0;
        for (int i = 0; i < numHands; i++) {
            String card = reader.readLine();
            String thisVal = card.substring(0, 1);
            String thisSuit = card.substring(1, 2);

            if (thisVal.equals("7") || thisVal.equals("8")) {
                continue;
            }

            if (thisSuit.equals(suit)) {
                sum += add(scores, thisVal, "X");
            } else {
                sum += add(scores, thisVal, "Y");
            }
        }

        System.out.println(sum);

    }

    public static int add(Map<String, Integer> scores, String thisVal, String append) {
        if (thisVal.equals("J") || thisVal.equals("9")) {
            return scores.get(thisVal + append);
        } else {
            return scores.get(thisVal);
        }
    }

}
