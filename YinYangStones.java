/*
Problem: https://open.kattis.com/problems/yinyangstones
Author: Adrian Reithaug
Submitted: June 8th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YinYangStones {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] stones = reader.readLine().toCharArray();

        int different = 0;
        for (char stone : stones) {
            different += (stone == 'B') ? 1 : -1;
        }

        System.out.println((different == 0) ? "1" : "0");
    }

}
