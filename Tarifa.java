/*
Problem: https://open.kattis.com/problems/tarifa
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarifa {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int megabytes = Integer.parseInt(reader.readLine());
        int numMonths = Integer.parseInt(reader.readLine());

        int total = megabytes;
        while (numMonths-- > 0) {
            int used = Integer.parseInt(reader.readLine());

            if (used > megabytes) {
                total += megabytes - used;
            } else {
                total += Math.abs(used - megabytes);
            }
        }

        System.out.println(total);
    }

}
