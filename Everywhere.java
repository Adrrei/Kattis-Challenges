/*
Problem: https://open.kattis.com/problems/everywhere
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Everywhere {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            Set<String> locations = new HashSet<>();
            int numTrips = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numTrips; i++) {
                locations.add(reader.readLine());
            }
            System.out.println(locations.size());
        }

    }

}
