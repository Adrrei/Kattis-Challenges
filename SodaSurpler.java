/*
Problem: https://open.kattis.com/problems/sodasurpler
Author: Adrian Reithaug
Submitted: June 8th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SodaSurpler {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");

        int found = Integer.parseInt(data[1]);
        int empty = Integer.parseInt(data[0]) + found;
        int cost = Integer.parseInt(data[2]);
        int sodas = 0;

        while (empty >= cost) {
            found = empty / cost;
            sodas += found;
            empty = empty % cost + found;
        }

        System.out.println(sodas);

    }

}
