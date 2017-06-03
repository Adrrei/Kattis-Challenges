/*
Problem: https://open.kattis.com/problems/leftbeehind
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftBeehind {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");
            int sweetJars = Integer.parseInt(data[0]);
            int sourJars = Integer.parseInt(data[1]);

            if (sweetJars == 0 && sourJars == 0) {
                break;
            }

            if (sweetJars + sourJars == 13) {
                System.out.println("Never speak again.");
            } else if (sourJars > sweetJars) {
                System.out.println("Left beehind.");
            } else if (sweetJars > sourJars) {
                System.out.println("To the convention.");
            } else {
                System.out.println("Undecided.");
            }

        }
    }

}
