/*
Problem: https://open.kattis.com/problems/pervasiveheartmonitor
Author: Adrian Reithaug
Submitted: June 10th, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PervasiveHeartMonitor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(" ");

            String customer = "";
            double averageBeats = 0;
            int numBeats = 0;

            for (String type : data) {
                if (type.charAt(0) >= 'A' && type.charAt(0) <= 'Z') {
                    customer += type + " ";
                } else {
                    averageBeats += Double.parseDouble(type);
                    numBeats++;
                }
            }

            System.out.println((averageBeats / numBeats) + " " + customer);

            line = reader.readLine();
        }
    }

}
