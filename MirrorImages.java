/*
Problem: https://open.kattis.com/problems/mirror
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.12s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorImages {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numCases; i++) {
            String[] values = reader.readLine().split(" ");
            int numRows = Integer.parseInt(values[0]);

            String[] images = new String[numRows];
            for (int j = images.length - 1; j >= 0; j--) {
                images[j] = new StringBuilder(reader.readLine()).reverse().toString();
            }

            System.out.println("Test " + i);
            for (String image : images) {
                System.out.println(image);
            }
        }

    }

}
