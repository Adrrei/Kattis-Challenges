/*
Problem: https://open.kattis.com/problems/spavanac
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spavanac {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] time = reader.readLine().split(" ");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);

        int sumMinutes = hours * 60 + minutes;
        int newTime = Math.abs(sumMinutes - 45);

        if (hours == 0 && minutes < 45) {
            System.out.println(23 + " " + (60 - 45 + minutes));
        } else {
            System.out.println((newTime / 60) + " " + (newTime % 60));
        }

    }

}
