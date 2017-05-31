/*
Problem: https://open.kattis.com/problems/dicecup
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.23s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiceCup {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] faces = reader.readLine().split(" ");
        int diceOne = Integer.parseInt(faces[0]);
        int diceTwo = Integer.parseInt(faces[1]);

        Map<Integer, Integer> probabilities = new LinkedHashMap<>();

        for (int i = 1; i <= diceOne + diceTwo; i++) {
            probabilities.put(i, 1);
        }

        for (int i = 1; i <= diceOne; i++) {
            for (int j = 1; j <= diceTwo; j++) {
                probabilities.put(i + j, probabilities.get(i + j) + 1);
            }
        }

        int maxValue = Collections.max(probabilities.values());
        probabilities.entrySet().stream().filter((entry) -> (entry.getValue() == maxValue)).forEachOrdered((entry) -> {
            System.out.println(entry.getKey());
        });

    }

}
