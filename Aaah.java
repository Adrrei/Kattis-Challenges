/*
Problem: https://open.kattis.com/problems/aaah
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aaah {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine().length() >= reader.readLine().length() ? "go" : "no");
    }

}
