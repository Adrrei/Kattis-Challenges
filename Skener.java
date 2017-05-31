/*
Problem: https://open.kattis.com/problems/skener
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.33s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skener {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        int rows = Integer.parseInt(values[0]);
        int columns = Integer.parseInt(values[1]);
        int altRows = Integer.parseInt(values[2]);
        int altColumns = Integer.parseInt(values[3]);

        for (int i = 0; i < rows; i++) {
            String row = reader.readLine();
            String altRow = "";

            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < altColumns; k++) {
                    altRow += row.charAt(j);
                    System.out.print(row.charAt(j));
                }
            }
            System.out.println("");

            for (int j = 1; j < altRows; j++) {
                System.out.println(altRow);
            }
        }

    }

}
