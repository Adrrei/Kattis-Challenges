/*
Problem: https://open.kattis.com/problems/chartingprogress
Author: Adrian Reithaug
Submitted: June 24th, 2017
Time: 0.62s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChartingProgress {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int pos = line.length();

        while (line != null) {

            if (line.isEmpty()) {
                System.out.println("");
                line = reader.readLine();
                pos = line.length();
                continue;
            }

            int length = line.length();
            int dots = length - line.replace(".", "").length();
            int stars = length - dots;

            String output = "";
            pos -= stars;

            for (int i = 0; i < pos; i++) {
                output += ".";
            }

            while (stars-- > 0) {
                output += "*";
            }

            while (output.length() < length) {
                output += ".";
            }

            System.out.println(output);

            line = reader.readLine();
        }

    }

}
