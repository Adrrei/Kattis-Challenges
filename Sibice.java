/*
Problem: https://open.kattis.com/problems/sibice
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sibice {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] setup = reader.readLine().split(" ");
        int numMatches = Integer.parseInt(setup[0]);
        int width = Integer.parseInt(setup[1]);
        int height = Integer.parseInt(setup[2]);

        while (numMatches-- > 0) {
            int length = Integer.parseInt(reader.readLine());
            double diagonal = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));

            if (length <= diagonal) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }

}
