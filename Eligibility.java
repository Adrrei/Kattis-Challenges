/*
Problem: https://open.kattis.com/problems/eligibility
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.19s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eligibility {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] information = reader.readLine().split(" ");
            String name = information[0];
            int startYear = Integer.parseInt(information[1].substring(0, 4));
            int birthYear = Integer.parseInt(information[2].substring(0, 4));
            int courses = Integer.parseInt(information[3]);

            System.out.print(name + " ");
            if (startYear >= 2010 || birthYear >= 1991) {
                System.out.print("eligible");
            } else if (courses < 41) {
                System.out.print("coach petitions");
            } else {
                System.out.print("ineligible");
            }
            System.out.println("");
        }

    }

}
