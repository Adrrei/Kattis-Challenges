/*
Problem: https://open.kattis.com/problems/detaileddifferences
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.32s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetailedDifferences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            String data1 = reader.readLine();
            String data2 = reader.readLine();

            System.out.println(data1 + "\n" + data2);

            for (int i = 0; i < data1.length(); i++) {
                System.out.print((data1.charAt(i) == data2.charAt(i)) ? "." : "*");
            }
            System.out.println("\n");
        }
    }

}
