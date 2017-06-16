/*
Problem: https://open.kattis.com/problems/whatdoesthefoxsay
Author: Adrian Reithaug
Submitted: June 16th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WhatDoesTheFoxSay {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            List<String> sounds = new ArrayList<>();
            String[] noises = reader.readLine().split(" ");
            String[] data = reader.readLine().split(" ");

            while (!data[data.length - 1].equals("say?")) {
                sounds.add(data[2]);
                data = reader.readLine().split(" ");
            }

            for (String noise : noises) {
                if (!sounds.contains(noise)) {
                    System.out.print(noise + " ");
                }
            }

            System.out.println("");
        }
    }

}
