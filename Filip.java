/*
Problem: https://open.kattis.com/problems/filip
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filip {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");
        StringBuilder first = new StringBuilder(numbers[0]).reverse();
        StringBuilder second = new StringBuilder(numbers[1]).reverse();

        int numberOne = Integer.parseInt(first.toString());
        int numberTwo = Integer.parseInt(second.toString());

        System.out.println(Math.max(numberOne, numberTwo));

    }

}
