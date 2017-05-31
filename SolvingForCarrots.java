/*
Problem: https://open.kattis.com/problems/carrots
Author: Adrian Reithaug
Submitted: January 29th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolvingForCarrots {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] data = reader.readLine().split(" ");
            int carrots = Integer.parseInt(data[1]);
            System.out.println(carrots);
            reader.close();
        } catch (Exception e) {
        }
    }

}
