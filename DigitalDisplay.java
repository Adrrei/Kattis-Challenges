/*
Problem: https://open.kattis.com/problems/display
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.34s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DigitalDisplay {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> mapping = new HashMap<>();
        mapping.put(0, "+---+|   ||   |+   +|   ||   |+---+");
        mapping.put(1, "    +    |    |    +    |    |    +");
        mapping.put(2, "+---+    |    |+---+|    |    +---+");
        mapping.put(3, "+---+    |    |+---+    |    |+---+");
        mapping.put(4, "+   +|   ||   |+---+    |    |    +");
        mapping.put(5, "+---+|    |    +---+    |    |+---+");
        mapping.put(6, "+---+|    |    +---+|   ||   |+---+");
        mapping.put(7, "+---+    |    |    +    |    |    +");
        mapping.put(8, "+---+|   ||   |+---+|   ||   |+---+");
        mapping.put(9, "+---+|   ||   |+---+    |    |+---+");

        while (true) {
            String time = reader.readLine();
            if (time.equals("end")) {
                break;
            }
            int[] digits = new int[4];

            int progress = 0;
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    continue;
                }
                digits[progress++] = Integer.parseInt(time.substring(i, i + 1));
            }

            progress = 0;
            for (int i = 0; i < 7; i++) {
                String n1 = mapping.get(digits[0]).substring(progress, progress + 5);
                String n2 = mapping.get(digits[1]).substring(progress, progress + 5);
                String n3 = mapping.get(digits[2]).substring(progress, progress + 5);
                String n4 = mapping.get(digits[3]).substring(progress, progress + 5);
                if (i == 2 || i == 4) {
                    System.out.print(n1 + "  " + n2 + "  o  " + n3 + "  " + n4);
                } else {
                    System.out.print(n1 + "  " + n2 + "     " + n3 + "  " + n4);
                }
                System.out.println("");
                progress += 5;
            }
            System.out.println("\n");
        }
        System.out.println("end");
    }

}
