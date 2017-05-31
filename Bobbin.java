/*
Problem: https://uib.kattis.com/problems/uib.bobbin
Author: Adrian Reithaug
Submitted: February 3rd, 2017
Time: 1.48s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bobbin {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numPeople = 0;
        int price = 0;
        List<Integer> money = new ArrayList<>();

        try {
            price = Integer.parseInt(reader.readLine());
            numPeople = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numPeople; i++) {
                money.add(Integer.parseInt(reader.readLine()));
            }

            reader.close();
        } catch (IOException e) {
        }

        Collections.sort(money);

        int[] prevSum = new int[numPeople];
        int startedAt = numPeople - 1;
        int bestHighest = numPeople - 1;
        int bestLowest = numPeople - 1;
        int lowestDiff = Integer.MAX_VALUE;

        for (int i = numPeople - 1; i >= 0; i--) {
            prevSum[i] = (i == numPeople - 1) ? money.get(i) : prevSum[i + 1] + money.get(i);
            int thisDiff = money.get(startedAt) - money.get(i);

            if (prevSum[i] >= price) {
                if (thisDiff == 0) {
                    break;
                }
                if (thisDiff < lowestDiff) {
                    lowestDiff = thisDiff;
                    bestHighest = startedAt;
                    bestLowest = i;
                }
                prevSum[i] = prevSum[i] - money.get(startedAt);
                startedAt--;
            }

        }
        System.out.println(money.get(bestLowest) + " " + money.get(bestHighest));

    }
}
