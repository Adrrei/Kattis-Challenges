/*
Problem: https://open.kattis.com/problems/akcija
Author: Adrian Reithaug
Submitted: June 2nd, 2017
Time: 0.30s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Akcija {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numBooks = Integer.parseInt(reader.readLine());
        int[] prices = new int[numBooks];

        for (int i = 0; i < numBooks; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(prices);

        int minSum = 0;
        for (int i = numBooks - 1; i >= 0; i--) {
            int price = prices[i];
            if ((i + 1) >= 3) {
                int currentPrice = prices[i] + prices[i - 1] + prices[i - 2];
                price = Math.min(prices[i], prices[i - 1]);
                price = currentPrice - Math.min(price, prices[i - 2]);
                i -= 2;
            }
            minSum += price;
        }
        System.out.println(minSum);

    }

}
