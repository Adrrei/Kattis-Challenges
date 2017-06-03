/*
Problem: https://open.kattis.com/problems/tri
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tri {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        int first = Integer.parseInt(data[0]);
        int second = Integer.parseInt(data[1]);
        int third = Integer.parseInt(data[2]);

        String operator = "";
        if (first + second == third) {
            operator = "+";
        } else if (first - second == third) {
            operator = "-";
        } else if (first * second == third) {
            operator = "*";
        } else if (first / second == third) {
            operator = "/";
        }

        if (operator.equals("")) {
            operator = "/";

            if (first == second + third) {
                operator = "+";
            } else if (first == second - third) {
                operator = "-";
            } else if (first == second * third) {
                operator = "*";
            }

            System.out.println(first + "=" + second + operator + third);
        } else {
            System.out.println(first + operator + second + "=" + third);
        }

    }

}
