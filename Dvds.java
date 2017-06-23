/*
Problem: https://open.kattis.com/problems/dvds
Author: Adrian Reithaug
Submitted: June 23rd, 2017
Time: 1.36s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dvds {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            reader.readLine();

            String[] dvds = reader.readLine().split(" ");

            int operations = 0;
            int position = 1;

            for (String dvd : dvds) {
                if (position != Integer.parseInt(dvd)) {
                    operations++;
                } else {
                    position++;
                }
            }

            System.out.println(operations);

        }
    }

}
