/*
Problem: https://open.kattis.com/problems/pot
Author: Adrian Reithaug
Submitted: May 30th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pot {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numAddends = Integer.parseInt(reader.readLine());
        long sum = 0;

        while (numAddends-- > 0) {
            String number = reader.readLine();
            int value = Integer.parseInt(number.substring(0, number.length() - 1));
            int power = Character.getNumericValue(number.charAt(number.length() - 1));
            sum += Math.pow(value, power);
        }

        System.out.println(sum);
    }

}
