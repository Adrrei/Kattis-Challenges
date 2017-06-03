/*
Problem: https://open.kattis.com/problems/timebomb
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Timebomb {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put("**** ** ** ****".hashCode(), 0);
        mapping.put("  *  *  *  *  *".hashCode(), 1);
        mapping.put("***  *****  ***".hashCode(), 2);
        mapping.put("***  ****  ****".hashCode(), 3);
        mapping.put("* ** ****  *  *".hashCode(), 4);
        mapping.put("****  ***  ****".hashCode(), 5);
        mapping.put("****  **** ****".hashCode(), 6);
        mapping.put("***  *  *  *  *".hashCode(), 7);
        mapping.put("**** ***** ****".hashCode(), 8);
        mapping.put("**** ****  ****".hashCode(), 9);

        String[] numbers = {"", "", "", "", "", "", "", ""};

        int pos = 0;
        for (int i = 0; i < 5; i++) {
            String data = reader.readLine();
            int index = 0;
            pos = 0;

            while (index < data.length()) {
                numbers[pos] = numbers[pos] + data.substring(index, index + 3);
                index += 4;
                pos++;
            }
        }

        String number = "";
        for (int i = 0; i < pos; i++) {
            int hash = numbers[i].hashCode();

            if (mapping.containsKey(hash)) {
                number += mapping.get(hash);
            } else {
                number = "1";
                break;
            }
        }

        if (Integer.parseInt(number) % 6 == 0) {
            System.out.println("BEER!!");
        } else {
            System.out.println("BOOM!!");
        }
    }

}
