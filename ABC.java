/*
Problem: https://open.kattis.com/problems/abc
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ABC {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        String order = reader.readLine();

        int length = data.length;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < length; i++) {
            switch (order.charAt(i)) {
                case 'A':
                    System.out.print(numbers[0]);
                    break;
                case 'B':
                    System.out.print(numbers[1]);
                    break;
                default:
                    System.out.print(numbers[2]);
                    break;
            }
            System.out.print(" ");
        }
    }

}
