/*
Problem: https://open.kattis.com/problems/nesteddolls
Author: Adrian Reithaug
Submitted: February 13th, 2017
Time: 1.94s / 6.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedDolls {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());

        while (numTestCases-- > 0) {
            int numDolls = Integer.parseInt(reader.readLine());
            int[][] nestedDolls = new int[numDolls][2];
            String[] data = reader.readLine().split(" ");

            int j = 0;
            for (int i = 0; i < numDolls; i++) {
                nestedDolls[i][0] = Integer.parseInt(data[j]);
                nestedDolls[i][1] = Integer.parseInt(data[j + 1]);
                j += 2;
            }

            // Sort the dolls by width (or by height, if width is equal)
            Arrays.sort(nestedDolls, (int[] doll1, int[] doll2) -> {
                return (doll1[0] == doll2[0]) ? Integer.compare(doll2[1], doll1[1]) : Integer.compare(doll1[0], doll2[0]);
            });

            nestedDolls[0][0] = 0;

            int length = 1;
            for (int i = 0; i < numDolls; i++) {
                int leftPos = 0;
                int rightPos = length;

                // Search for overlapping heights
                while (leftPos < rightPos) {
                    int mid = leftPos + ((rightPos - leftPos) / 2);

                    if (nestedDolls[mid][0] >= nestedDolls[i][1]) {
                        leftPos = mid + 1;
                    } else {
                        rightPos = mid;
                    }
                }

                if (leftPos == length) {
                    nestedDolls[length++][0] = nestedDolls[i][1];
                } else {
                    nestedDolls[leftPos][0] = nestedDolls[i][1];
                }
            }

            System.out.println(length);
        }

    }
}
