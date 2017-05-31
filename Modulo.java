/*
Problem: https://open.kattis.com/problems/modulo
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Modulo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int LIFE = 42; // *

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(reader.readLine());
            set.add(number % LIFE);
        }
        System.out.println(set.size());

    }

}
