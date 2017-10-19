/*
Problem: https://open.kattis.com/problems/nastyhacks
Author: Adrian Reithaug
Submitted: October 19th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NastyHacks {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String[] money = reader.readLine().split(" ");
            int noAdvert = Integer.parseInt(money[0]);
            int advert = Integer.parseInt(money[1]);
            int cost = Integer.parseInt(money[2]);

            if ((advert - cost) > noAdvert) {
                System.out.println("advertise");
            } else if ((advert - cost) < noAdvert) {
                System.out.println("do not advertise");
            } else {
                System.out.println("does not matter");
            }
        }
    }

}
