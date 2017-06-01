/*
Problem: https://open.kattis.com/problems/kornislav
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kornislav {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] distances = reader.readLine().split(" ");
        int[] steps = new int[distances.length];
        for (int i = 0; i < distances.length; i++) {
            steps[i] = Integer.parseInt(distances[i]);
        }

        Arrays.sort(steps);

        System.out.println(steps[0] * steps[2]);

    }

}
