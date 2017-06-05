/*
Problem: https://open.kattis.com/problems/parking2
Author: Adrian Reithaug
Submitted: June 5th, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            int numStores = Integer.parseInt(reader.readLine());
            String[] data = reader.readLine().split(" ");

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < numStores; i++) {
                int position = Integer.parseInt(data[i]);
                if (position < min) {
                    min = position;
                }
                if (position > max) {
                    max = position;
                }
            }

            System.out.println((max - min) * 2);
        }
    }

}
