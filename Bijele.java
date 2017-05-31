/*
Problem: https://open.kattis.com/problems/bijele
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bijele {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pieces = reader.readLine().split(" ");
        int[] set = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < 6; i++) {
            int piece = Integer.parseInt(pieces[i]);

            System.out.print((set[i] - piece) + " ");
        }

    }

}
