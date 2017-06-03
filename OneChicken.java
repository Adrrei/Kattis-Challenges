/*
Problem: https://open.kattis.com/problems/onechicken
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.18s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneChicken {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        int numPeople = Integer.parseInt(data[0]);
        int numPieces = Integer.parseInt(data[1]);

        if (numPeople > numPieces) {
            int need = numPeople - numPieces;
            System.out.print("Dr. Chaz needs ");
            if (need == 1) {
                System.out.print(need + " more piece of chicken!");
            } else {
                System.out.print(need + " more pieces of chicken!");
            }
        } else {
            int left = numPieces - numPeople;
            System.out.print("Dr. Chaz will have ");
            if (left == 1) {
                System.out.print(left + " piece of chicken left over!");
            } else {
                System.out.print(left + " pieces of chicken left over!");
            }
        }
        System.out.println("");
    }

}
