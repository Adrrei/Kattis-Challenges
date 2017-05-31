/*
Problem: https://open.kattis.com/problems/grassseed
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrassSeed {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double cost = Double.parseDouble(reader.readLine());
        int numLawns = Integer.parseInt(reader.readLine());

        double totalCost = 0;
        while (numLawns-- > 0) {
            String[] lawn = reader.readLine().split(" ");
            double width = Double.parseDouble(lawn[0]);
            double height = Double.parseDouble(lawn[1]);

            totalCost += width * height * cost;
        }

        System.out.println(totalCost);
    }

}
