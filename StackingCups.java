/*
Problem: https://open.kattis.com/problems/cups
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.24s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StackingCups {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCups = Integer.parseInt(reader.readLine());

        List<Cup> cups = new ArrayList<>();

        while (numCups-- > 0) {
            String[] values = reader.readLine().split(" ");

            if (values[0].matches("\\d+")) {
                cups.add(new Cup(values[1], Integer.parseInt(values[0]) / 2));
            } else {
                cups.add(new Cup(values[0], Integer.parseInt(values[1])));
            }
        }

        Collections.sort(cups, (Cup c1, Cup c2) -> Integer.compare(c1.radius, c2.radius));

        cups.forEach((c) -> {
            System.out.println(c.color);
        });
    }

    public static class Cup {

        String color;
        int radius;

        Cup(String color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }

}
