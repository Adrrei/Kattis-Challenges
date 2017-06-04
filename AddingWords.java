/*
Problem: https://open.kattis.com/problems/addingwords
Author: Adrian Reithaug
Submitted: June 4th, 2017
Time: 0.27s / 5.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AddingWords {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> numToStr = new HashMap<>();
        Map<String, Integer> StrToNum = new HashMap<>();

        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(" ");

            if (data[0].equals("clear")) {
                numToStr = new HashMap<>();
                StrToNum = new HashMap<>();

            } else if (data[0].equals("def")) {
                int newValue = Integer.parseInt(data[2]);
                numToStr.remove(StrToNum.get(data[1]));
                numToStr.put(newValue, data[1]);
                StrToNum.put(data[1], newValue);

            } else if (data[0].equals("calc")) {
                int sum = 0;
                boolean unknown = false;
                char operator = '+';

                for (int i = 1; i < data.length - 1; i++) {
                    if (data[i].equals("+")) {
                        operator = '+';
                        continue;
                    }
                    if (data[i].equals("-")) {
                        operator = '-';
                        continue;
                    }
                    if (StrToNum.containsKey(data[i])) {
                        int value = StrToNum.get(data[i]);
                        sum += (operator == '+') ? value : -value;
                    } else {
                        unknown = true;
                        break;
                    }
                }

                String result = (!unknown && numToStr.containsKey(sum)) ? numToStr.get(sum) : "unknown";
                System.out.println(line.substring(5) + " " + result);

            }

            line = reader.readLine();
        }
    }

}
