/*
Problem: https://open.kattis.com/problems/different
Author: Adrian Reithaug
Submitted: January 19th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Different {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        while ((input = reader.readLine()) != null) {
            String[] inArr = input.split(" ");
            System.out.println(Math.abs(Long.parseLong(inArr[0]) - Long.parseLong(inArr[1])));
        }
    }

}
