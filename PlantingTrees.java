/*
Problem: https://open.kattis.com/problems/plantingtrees
Author: Adrian Reithaug
Submitted: June 17th, 2017
Time: 0.36s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlantingTrees {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numSeedlings = Integer.parseInt(reader.readLine());

        String[] strDays = reader.readLine().split(" ");
        int[] days = new int[numSeedlings];

        for (int i = 0; i < numSeedlings; i++) {
            days[i] = Integer.parseInt(strDays[i]);
        }

        Arrays.sort(days);
        int earliest = 0;

        for (int i = numSeedlings - 1; i >= 0; i--) {
            if (days[i] - i + numSeedlings > earliest) {
                earliest = days[i] - i + numSeedlings;
            }
        }

        System.out.println(earliest + 1);
    }

}
