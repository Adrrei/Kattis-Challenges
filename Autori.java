/*
Problem: https://open.kattis.com/problems/autori
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Autori {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine().replaceAll("([a-z-])", "");

        System.out.println(line);
    }

}
