/*
Problem: https://open.kattis.com/problems/acm
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AcmContestScoring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int score = 0;
        int numCorrect = 0;
        Map<String, Integer> submissions = new HashMap<>();

        while (true) {
            String[] data = reader.readLine().split(" ");

            if (data[0].equals("-1")) {
                break;
            }

            if (data[2].equals("wrong")) {
                if (submissions.containsKey(data[1])) {
                    submissions.put(data[1], submissions.get(data[1]) + 1);
                } else {
                    submissions.put(data[1], 1);
                }
                continue;
            }

            numCorrect++;
            score += Integer.parseInt(data[0]);
            if (submissions.containsKey(data[1])) {
                score += submissions.get(data[1]) * 20;
            }

        }

        System.out.println(numCorrect + " " + score);
    }

}
