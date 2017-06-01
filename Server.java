/*
Problem: https://open.kattis.com/problems/server
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.09s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        String[] minutes = reader.readLine().split(" ");

        int numTasks = 0;
        int timeAvailable = Integer.parseInt(data[1]);

        for (String minute : minutes) {
            int time = Integer.parseInt(minute);

            if (time <= timeAvailable) {
                numTasks++;
                timeAvailable -= time;
            } else {
                break;
            }
        }

        System.out.println(numTasks);
    }

}
