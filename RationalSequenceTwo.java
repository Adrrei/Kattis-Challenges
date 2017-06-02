/*
Problem: https://open.kattis.com/problems/rationalsequence2
Author: Adrian Reithaug
Submitted: June 2nd, 2017
Time: 0.18s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RationalSequenceTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] data = reader.readLine().split(" ");
            String[] node = data[1].split("/");
            int numerator = Integer.parseInt(node[0]);
            int denominator = Integer.parseInt(node[1]);

            String traversal = "";
            while (numerator > 1 || denominator > 1) {
                if (numerator > denominator) {
                    traversal += "R";
                    numerator -= denominator;
                } else {
                    traversal += "L";
                    denominator -= numerator;
                }
            }

            int position = 0;
            for (int i = traversal.length() - 1; i >= 0; i--) {
                position = (traversal.charAt(i) == 'R') ? 2 * (position + 1) : (2 * position) + 1;
            }

            System.out.println(data[0] + " " + (position + 1));
        }
    }

}
