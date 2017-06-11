/*
Problem: https://open.kattis.com/problems/raggedright
Author: Adrian Reithaug
Submitted: June 11th, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RaggedRight {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = new ArrayList<>();
        int maxLength = 0;

        String line = reader.readLine();
        while (line != null) {
            lines.add(line);

            if (line.length() > maxLength) {
                maxLength = line.length();
            }

            line = reader.readLine();
        }

        int score = 0;
        for (int i = 0; i < lines.size() - 1; i++) {
            score += Math.pow(maxLength - lines.get(i).length(), 2);
        }

        System.out.println(score);
    }

}
