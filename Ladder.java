/*
Problem: https://open.kattis.com/problems/ladder
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ladder {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        int height = Integer.parseInt(values[0]);
        double degrees = Math.toRadians(Integer.parseInt(values[1]));
        int hypotenuse = (int) Math.ceil(height / Math.sin(degrees));

        System.out.println(hypotenuse);

    }

}
