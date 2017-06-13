/*
Problem: https://open.kattis.com/problems/cd
Author: Adrian Reithaug
Submitted: June 13th, 2017
Time: 1.04s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");

            int numJack = Integer.parseInt(data[0]);
            int numJill = Integer.parseInt(data[1]);

            if (numJack == 0 && numJill == 0) {
                break;
            }

            int[] jackCatalog = new int[numJack];

            for (int i = 0; i < numJack; i++) {
                jackCatalog[i] = Integer.parseInt(reader.readLine());
            }

            int numEqual = 0;
            for (int i = 0; i < numJill; i++) {
                int cd = Integer.parseInt(reader.readLine());
                int leftPos = 0;
                int rightPos = numJack - 1;

                while (leftPos <= rightPos) {
                    int mid = leftPos + ((rightPos - leftPos) / 2);

                    if (jackCatalog[mid] < cd) {
                        leftPos = mid + 1;
                    } else if (jackCatalog[mid] > cd) {
                        rightPos = mid - 1;
                    } else {
                        numEqual++;
                        break;
                    }
                }
            }

            System.out.println(numEqual);
        }
    }

}
