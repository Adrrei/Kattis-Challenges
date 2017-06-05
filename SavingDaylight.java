/*
Problem: https://open.kattis.com/problems/savingdaylight
Author: Adrian Reithaug
Submitted: June 5th, 2017
Time: 0.24s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SavingDaylight {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(" |\\:");

            int hours = Integer.parseInt(data[5]) - Integer.parseInt(data[3]);
            int minutes = Integer.parseInt(data[6]) - Integer.parseInt(data[4]);

            if (minutes < 0) {
                hours--;
                minutes += 60;
            }

            System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + hours + " hours " + minutes + " minutes");

            line = reader.readLine();
        }
    }

}
