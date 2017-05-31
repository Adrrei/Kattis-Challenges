/*
Problem: https://open.kattis.com/problems/spiderman
Author: Adrian Reithaug
Submitted: February 17th, 2017
Time: 0.21s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpidermansWorkout {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int UP = 1;
        final int DOWN = -1;

        int numTestScenarios = Integer.parseInt(reader.readLine());

        while (numTestScenarios-- > 0) {
            int numDistances = Integer.parseInt(reader.readLine());
            String[] data = reader.readLine().split(" ");

            int[] distances = new int[numDistances];
            int maxDistance = 0;
            int largestDistance = 0;

            for (int i = 0; i < numDistances; i++) {
                distances[i] = Integer.parseInt(data[i]);
                maxDistance += distances[i];
                if (distances[i] > largestDistance) {
                    largestDistance = distances[i];
                }
            }
            largestDistance += maxDistance + 1;

            int[][] positions = new int[numDistances + 1][largestDistance];
            int[][] directions = new int[numDistances + 1][largestDistance];

            for (int[] array : positions) {
                Arrays.fill(array, maxDistance);
            }
            positions[0][0] = 0;

            for (int thisPos = 0; thisPos < numDistances; thisPos++) {
                for (int thisDist = 0; thisDist <= maxDistance; thisDist++) {
                    int currentDistance = positions[thisPos][thisDist];
                    int up = thisDist + distances[thisPos];
                    int down = thisDist - distances[thisPos];
                    int next = thisPos + 1;

                    if (positions[next][up] > Math.max(up, currentDistance)) {
                        positions[next][up] = Math.max(up, currentDistance);
                        directions[next][up] = UP;
                    }

                    if (down >= 0 && positions[next][down] > currentDistance) {
                        positions[next][down] = currentDistance;
                        directions[next][down] = DOWN;
                    }

                }
            }

            String path = "";
            int height = positions[numDistances][0];
            if (height != maxDistance) {
                int distance = 0;
                for (int thisPos = numDistances; thisPos > 0; thisPos--) {
                    if (directions[thisPos][distance] == UP) {
                        distance -= distances[thisPos - 1];
                        path += "U";
                    } else {
                        distance += distances[thisPos - 1];
                        path += "D";
                    }
                }
                System.out.println(new StringBuilder(path).reverse());
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}
