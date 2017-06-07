/*
Problem: https://open.kattis.com/problems/bus
Author: Adrian Reithaug
Submitted: June 7th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            System.out.println((int) Math.pow(2, Integer.parseInt(reader.readLine())) - 1);
        }
    }

}
