/*
Problem: https://open.kattis.com/problems/parking
Author: Adrian Reithaug
Submitted: June 4th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pricesStr = reader.readLine().split(" ");
        int[] prices = new int[4];
        prices[0] = 0;

        for (int i = 1; i <= 3; i++) {
            prices[i] = Integer.parseInt(pricesStr[i - 1]) * i;
        }

        Time[] minutes = new Time[3];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            String[] minutesStr = reader.readLine().split(" ");
            int arrival = Integer.parseInt(minutesStr[0]);
            int departure = Integer.parseInt(minutesStr[1]);
            minutes[i] = new Time(arrival, departure);

            if (arrival < min) {
                min = arrival;
            }
            if (departure > max) {
                max = departure;
            }
        }

        int cost = 0;
        for (int i = min; i <= max; i++) {
            int numTrucks = 0;

            for (int j = 0; j < 3; j++) {
                if (minutes[j].arrival <= i && minutes[j].departure > i) {
                    numTrucks++;
                }
            }
            cost += prices[numTrucks];

        }
        System.out.println(cost);

    }

    static class Time {

        int arrival;
        int departure;

        Time(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }

}
