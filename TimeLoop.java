/*
Problem: https://open.kattis.com/problems/timeloop
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeLoop {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numChants = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numChants; i++) {
            System.out.println(i + " Abracadabra");
        }

    }

}
