/*
Problem: https://open.kattis.com/problems/busnumbers
Author: Adrian Reithaug
Submitted: June 14th, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numBuses = Integer.parseInt(reader.readLine());
        List<Integer> buses = new ArrayList<>();

        String[] busNumbers = reader.readLine().split(" ");
        for (int i = 0; i < numBuses; i++) {
            buses.add(Integer.parseInt(busNumbers[i]));
        }

        if (numBuses == 1) {
            System.out.println(buses.get(0));
            return;
        }

        Collections.sort(buses);

        int start = 0, numAdjacent = 1;
        boolean adjacent = true;

        for (int i = 1; i < numBuses; i++) {
            if (buses.get(i - 1) == (buses.get(i) - 1)) {
                numAdjacent++;
            } else {
                adjacent = false;
            }

            boolean lastBus = (i == numBuses - 1);

            if (lastBus || !adjacent) {
                if (numAdjacent > 2) {
                    System.out.print(buses.get(start) + "-");
                    if (!adjacent) {
                        System.out.print(buses.get(i - 1) + " ");
                    }
                } else {
                    for (int j = start; j < i; j++) {
                        System.out.print(buses.get(j) + " ");
                    }
                }

                start = i;
                numAdjacent = 1;
                adjacent = true;
            }

            if (lastBus) {
                System.out.println(buses.get(i));
            }

        }
    }

}
