/*
Problem: https://open.kattis.com/problems/r2
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        int r1 = Integer.parseInt(values[0]);
        int s = Integer.parseInt(values[1]);

        for (int r2 = -1000; r2 <= 1000; r2++) {
            if ((r1 + r2) / 2 == s) {
                System.out.println(r2);
                break;
            }
        }
    }

}
