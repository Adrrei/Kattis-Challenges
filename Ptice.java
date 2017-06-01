/*
Problem: https://open.kattis.com/problems/ptice
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ptice {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine(); // Unnecessary
        char[] answers = reader.readLine().toCharArray();

        String[] sequences = {"ABC", "BABC", "CCAABB"};
        String[] applicants = {"Adrian", "Bruno", "Goran"};
        int[] score = {0, 0, 0};
        int[] pos = {0, 0, 0};

        for (char answer : answers) {
            for (int i = 0; i < 3; i++) {
                score[i] += (sequences[i].charAt(pos[i]) == answer) ? 1 : 0;
                pos[i] = ((pos[i] + 1) % sequences[i].length() == 0) ? 0 : pos[i] + 1;
            }
        }

        int max = score[0];
        String result = applicants[0] + "\n";
        for (int i = 1; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
                result = applicants[i] + "\n";
            } else if (score[i] == max) {
                result += applicants[i] + "\n";
            }
        }

        System.out.println(max + "\n" + result.trim());

    }

}
