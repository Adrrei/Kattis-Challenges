/*
Problem: https://open.kattis.com/problems/quiteaproblem
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.18s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuiteAProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line.toLowerCase().contains("problem") ? "yes" : "no");
            line = reader.readLine();
        }
    }

}
