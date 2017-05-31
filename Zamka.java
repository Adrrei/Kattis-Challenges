/*
Problem: https://open.kattis.com/problems/zamka
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zamka {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int L = Integer.parseInt(reader.readLine());
        final int D = Integer.parseInt(reader.readLine());
        final int X = Integer.parseInt(reader.readLine());

        for (int i = L; i <= D; i++) {
            if (sum(i) == X) {
                System.out.println(i);
                break;
            }
        }

        for (int i = D; i >= L; i--) {
            if (sum(i) == X) {
                System.out.println(i);
                break;
            }
        }

    }

    public static int sum(int value) {
        int total = 0;

        while (value > 0) {
            total += value % 10;
            value /= 10;
        }
        return total;
    }

}
