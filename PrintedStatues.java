/*
Problem: https://open.kattis.com/problems/3dprinter
Author: Adrian Reithaug
Submitted: June 18th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintedStatues {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numStatues = Integer.parseInt(reader.readLine());
        int numDays = 1;
        int numPrinters = 1;

        while (numPrinters < numStatues) {
            numPrinters *= 2;
            numDays++;
        }

        System.out.println(numDays);
    }

}
