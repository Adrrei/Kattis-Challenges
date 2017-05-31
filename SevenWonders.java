/*
Problem: https://open.kattis.com/problems/sevenwonders
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SevenWonders {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] cards = reader.readLine().toCharArray();

        Map<Character, Integer> points = new LinkedHashMap<>();
        points.put('T', 0);
        points.put('C', 0);
        points.put('G', 0);

        for (char c : cards) {
            points.put(c, points.get(c) + 1);
        }

        int i = 0;
        int sum = 0;
        int[] values = new int[3];

        for (Map.Entry<Character, Integer> entry : points.entrySet()) {
            int value = entry.getValue();
            sum += Math.pow(value, 2);
            values[i++] = value;
        }
        
        int min = values[0];
        for (i = 1; i < values.length; i++) {
            min = Math.min(min, values[i]);
        }

        System.out.println(sum + min * 7);

    }

}
