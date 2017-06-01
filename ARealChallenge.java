/*
Problem: https://open.kattis.com/problems/areal
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ARealChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long area = Long.parseLong(reader.readLine());
        System.out.println(Math.sqrt(area) * 4);

    }

}
