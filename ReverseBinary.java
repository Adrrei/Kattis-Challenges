/*
Problem: https://open.kattis.com/problems/reversebinary
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        StringBuilder binary = new StringBuilder();
        binary.append(Integer.toBinaryString(number));
        binary.reverse();

        number = Integer.parseInt(binary.toString(), 2);

        System.out.println(number);

    }

}
