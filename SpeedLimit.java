/*
Problem: https://open.kattis.com/problems/speedlimit
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeedLimit {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int dataSets = Integer.parseInt(reader.readLine());

            if (dataSets == -1) {
                break;
            }

            int miles = 0;
            int prevTime = 0;

            while (dataSets-- > 0) {
                String[] set = reader.readLine().split(" ");
                int speed = Integer.parseInt(set[0]);
                int hours = Integer.parseInt(set[1]);

                miles += speed * (hours - prevTime);
                prevTime = hours;
            }
            System.out.println(miles + " miles");

        }

    }

}
