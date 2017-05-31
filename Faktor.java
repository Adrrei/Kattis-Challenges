/*
Problem: https://open.kattis.com/problems/faktor
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Faktor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        int numPublish = Integer.parseInt(values[0]);
        int factor = Integer.parseInt(values[1]);

        int numScientists = numPublish * (factor - 1) + 1;

        System.out.println(numScientists);

    }

}
